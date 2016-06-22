package action;

import java.io.File;
import java.util.List;

import po.Brand;
import po.Shipping;
import service.BrandService;
import service.Service;
import utils.HtmlUtils;
import excel.BrandExcelUpload;
import excel.ExcelUpload;
import factory.DaoFactory;

public class BrandAction extends FileUploadAction {

	private Brand brand;

	public BrandAction() {
		super();
		service = new BrandService();
		this.startRow = 0;
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
	public String initEdit() {

		brand = (Brand) service.get(Brand.class, brand.getId());
		return super.initEdit();
	}

	@Override
	public String edit() {
		try {
			service.update(brand);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	@Override
	public String list() {

		try {
			if (brand == null) {
				brand = new Brand();
			}

			int maxRow = service.findTotalRow(brand);
			maxPage = maxRow % NUM_OF_ROW_PER_PAGE == 0 ? maxRow / NUM_OF_ROW_PER_PAGE
					: maxRow / NUM_OF_ROW_PER_PAGE + 1;

			brandList = service.findByPaging(brand, pageNo);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	@Override
	public void ajaxListByPage() {
		String status = list();
		if (SUCCESS.equals(status)) {
			writeToHtml(HtmlUtils.generateShippingSearchResult(brandList));
		} else {
			writeToHtml("Error Found!");
		}

	}
}
