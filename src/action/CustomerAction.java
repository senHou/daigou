package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import factory.DaoFactory;
import po.Shipping;
import service.CustomerService;
import service.Service;

public class CustomerAction extends ActionSupport{

	private CustomerService service;
	
	public CustomerAction(){
		service = new CustomerService(DaoFactory.CUSTOMER);
	}
	
	
	public void getShippings(String customerId) {
		List<Shipping> shippingList = service.getCustomerShippings(customerId);
		
		for (Shipping shipping : shippingList) {
			System.out.println(shipping.getShippingCompany());
		}
	}
}
