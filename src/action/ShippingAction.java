package action;

import java.util.List;

import factory.DaoFactory;
import po.Brand;
import po.Customer;
import po.Shipping;
import po.ShippingCompany;
import po.ShippingDetail;
import service.Service;
import service.ShippingService;
import utils.DateUtils;

public class ShippingAction extends CommonAction{
	
	private List shippingCompanyList;
	private List customerList;
	private Service service;
	private List shippingList;
	private Shipping shipping;
	private String errorMessage;
	private List brandList;
	private String date;
	private List<ShippingDetail> detailList; 
	
	public ShippingAction(){
		super();
		service = new ShippingService(DaoFactory.SHIPPING);		
	}
	
	public String initAdd(){
		
		if (dataManager.getDataMap().get(CommonAction.SHIPPING_COMPANY_LIST) == null) {
			shippingCompanyList = service.getAll(ShippingCompany.class);
			dataManager.getDataMap().put(CommonAction.SHIPPING_COMPANY_LIST, shippingCompanyList);
		}else {
			shippingCompanyList = dataManager.getDataMap().get(CommonAction.SHIPPING_COMPANY_LIST);
		}
		
		if (dataManager.getDataMap().get(CommonAction.CUSTOMER_LIST) == null) {
			customerList = service.getAll(Customer.class);
			dataManager.getDataMap().put(CommonAction.CUSTOMER_LIST, customerList);
		}else {
			customerList = dataManager.getDataMap().get(CommonAction.CUSTOMER_LIST);
		}
		
		if (dataManager.getDataMap().get(CommonAction.BRAND_LIST) == null) {
			brandList = service.getAll(Brand.class);
			dataManager.getDataMap().put(CommonAction.BRAND_LIST, brandList);
		}else {
			brandList = dataManager.getDataMap().get(CommonAction.BRAND_LIST);
		}
		return SUCCESS;
	}
	
	public String add(){
		try {
			shipping.setDate(DateUtils.parseStringToDate(date, "yyyy/MM/dd"));
			shipping.getShippingDetailSet().addAll(detailList);
			service.save(shipping);
			errorMessage = null;
			return SUCCESS;
		}catch(Exception e) {
			errorMessage = "Add shipping error.";
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String display(){
		shippingList = service.getAll(Shipping.class);
		return SUCCESS;
	}
	
	public void setShippingCompanyList(List shippingCompanyList) {
		this.shippingCompanyList = shippingCompanyList;
	}
	
	public List getShippingCompanyList() {
		return shippingCompanyList;
	}
	
	public Shipping getShipping() {
		return shipping;
	}
	
	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}
	
	public List getCustomerList() {
		return customerList;
	}
	
	public void setCustomerList(List customerList) {
		this.customerList = customerList;
	}
	
	public List getShippingList() {
		return shippingList;
	}
	
	public void setShippingList(List shippingList) {
		this.shippingList = shippingList;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<Brand> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<Brand> brandList) {
		this.brandList = brandList;
	}

	@Override
	public String edit() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public List<ShippingDetail> getDetailList() {
		return detailList;
	}
	
	public void setDetailList(List<ShippingDetail> detailList) {
		this.detailList = detailList;
	}
}
