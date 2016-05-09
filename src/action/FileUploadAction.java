package action;

import com.opensymphony.xwork2.ActionSupport;

import excel.ExcelUpload;

public abstract class FileUploadAction extends CommonAction {

	protected String fileName;
	protected int sheetIdx = 0;
	protected int startRow;

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

	public abstract void uploadFile();
	
	public  String initFile(){
		return SUCCESS;
	}

}
