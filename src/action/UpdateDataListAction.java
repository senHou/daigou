package action;

import com.opensymphony.xwork2.ActionSupport;

import po.Brand;
import po.Customer;
import po.ShippingCompany;
import service.Service;
import utils.DataManager;

public class UpdateDataListAction extends ActionSupport {

	private String updateType;
	private DataManager dataManager;
	
	public void updateDataList() {
		try {
			dataManager = DataManager.getInstance();
			Service service = new Service();
			if ("all".equalsIgnoreCase(updateType)) {
				dataManager.getDataMap().put(CommonAction.BRAND_LIST, service.getAll(Brand.class));
				dataManager.getDataMap().put(CommonAction.SHIPPING_COMPANY_LIST, service.getAll(ShippingCompany.class));
				dataManager.getDataMap().put(CommonAction.CUSTOMER_LIST, service.getAll(Customer.class));
			} else if (updateType.equalsIgnoreCase(CommonAction.BRAND_LIST)) {
				dataManager.getDataMap().put(CommonAction.BRAND_LIST, service.getAll(Brand.class));
			} else if (updateType.equalsIgnoreCase(CommonAction.SHIPPING_COMPANY_LIST)) {
				dataManager.getDataMap().put(CommonAction.SHIPPING_COMPANY_LIST, service.getAll(ShippingCompany.class));
			} else {
				dataManager.getDataMap().put(CommonAction.CUSTOMER_LIST, service.getAll(Customer.class));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String initUpdateDataList() {
		return SUCCESS;
	}

	public String getUpdateType() {
		return updateType;
	}

	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}
}
