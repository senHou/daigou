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
	
	
	ExcelUpload uploadAction;
	Service service;
	Brand brand;
	public BrandAction() {
		service = new BrandService(DaoFactory.BRAND);
		this.startRow = 0;
	}

	public String initBrandFile(){
		return SUCCESS;
	}
	
	@Override
	public void uploadFile() {
		try{
			File file = new File(getFileName());
			uploadAction = new BrandExcelUpload(file);
			List<Brand> brandList = (List<Brand>)uploadAction.upload(sheetIdx, startRow);
			service.saveAll(brandList);
		}catch(Exception e) {
			
		}
	}
	
	public String AddBrand(){
		System.out.println("testing");
		service.save(brand);
		return SUCCESS;
	}
	
	public String initAddBrand(){
		return SUCCESS;
	}

	public Brand getBrand() {
		return brand;
	}
	
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
}
