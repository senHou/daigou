package action;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import factory.DaoFactory;
import po.Brand;
import po.Customer;
import po.Shipping;
import po.ShippingCompany;
import service.Service;
import service.ShippingService;

public class ShippingAction extends ActionSupport{
	
	private List shippingCompanyList;
	private List customerList;
	private Service service;
	private List shippingList;
	private Shipping shipping;
	private String errorMessage;
	private List brandList;
	
	public ShippingAction(){
		service = new ShippingService(DaoFactory.SHIPPING);
	}
	
	public String initAddShipping(){
		shippingCompanyList = service.getAll(ShippingCompany.class);
		customerList = service.getAll(Customer.class);
		brandList = service.getAll(Brand.class);
		return SUCCESS;
	}
	
	public String addShipping(){
		try {
			service.save(shipping);
			errorMessage = null;
			return SUCCESS;
		}catch(Exception e) {
			errorMessage = "Add shipping error.";
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
}
