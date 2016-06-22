package action;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.List;

import excel.BrandExcelUpload;
import excel.ExcelUpload;
import service.Service;

public abstract class FileUploadAction extends CommonAction {
	protected ExcelUpload uploadAction;
	protected String fileName;
	protected int sheetIdx = 0;
	protected int startRow;
	protected String uploadType;

	public FileUploadAction() {
		super();
		service = new Service();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getSheetIdx() {
		return sheetIdx;
	}

	public void setSheetIdx(int sheetIdx) {
		this.sheetIdx = sheetIdx;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public String getUploadType() {
		return uploadType;
	}
	
	public void setUploadType(String uploadType) {
		this.uploadType = uploadType;
	}
	
	public String uploadFile() {
		try {
			File file = new File(getFileName());
			uploadAction = createObject(file);
			List list = uploadAction.upload(sheetIdx, startRow);
			service.saveAll(list);
			setErrorMessage(null);
			return SUCCESS;
		} catch (Exception e) {
			setErrorMessage("Add customer error");
			e.printStackTrace();
			return ERROR;
		}
	}

	public String initFile() {
		return SUCCESS;
	}
	
	private ExcelUpload createObject(File file) {
		ExcelUpload uploadAction = null;
		StringBuffer name = new StringBuffer("excel.");
		String className = this.getClass().getSimpleName();
		className = className.substring(0, className.lastIndexOf("Action"));
		name.append(className);
		name.append("ExcelUpload");
		try{
			Class<ExcelUpload> excelUploadClass = (Class<ExcelUpload>)Class.forName(name.toString());
			Constructor<ExcelUpload> constructor = excelUploadClass.getConstructor(file.getClass());
			uploadAction = constructor.newInstance(file);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return uploadAction;
	}
	
	public static void main(String[] args) {
		FileUploadAction action = new BrandAction();
		action.createObject(new File(""));
	}

}
