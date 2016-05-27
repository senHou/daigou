package action;

import java.io.File;
import java.util.List;

import po.Brand;
import service.BrandService;
import service.Service;
import excel.BrandExcelUpload;
import excel.ExcelUpload;
import factory.DaoFactory;

public class BrandAction extends FileUploadAction{
	
	private ExcelUpload uploadAction;
	private Service service;
	private Brand brand;
	
	public BrandAction() {
		super();
		service = new BrandService();
		this.startRow = 0;
	}
	
	@Override
	public String uploadFile() {
		try{
			File file = new File(getFileName());
			uploadAction = new BrandExcelUpload(file);
			List<Brand> brandList = (List<Brand>)uploadAction.upload(sheetIdx, startRow);
			service.saveAll(brandList);
			setErrorMessage(null);
			return SUCCESS;
		}catch(Exception e) {
			setErrorMessage("Add customer error");
			return ERROR;
		}
	}
	

	public Brand getBrand() {
		return brand;
	}
	
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Override
	public String add() {
		service.save(brand);
		return SUCCESS;
	}

	@Override
	public String edit() {
		return null;
	}

	@Override
	public String list() {
		// TODO Auto-generated method stub
		return null;
	}

}
