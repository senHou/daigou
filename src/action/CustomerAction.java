package action;

import java.io.File;
import java.util.List;

import excel.CustomerExcelUpload;
import excel.ExcelUpload;
import factory.DaoFactory;
import po.Customer;
import po.Shipping;
import service.CustomerService;

public class CustomerAction extends FileUploadAction{

	private CustomerService service;
	private ExcelUpload uploadAction;
	private Customer customer;
	public CustomerAction(){
		service = new CustomerService(DaoFactory.CUSTOMER);
		this.startRow = 0;
	}
	
	
	public void getShippings(String customerId) {
		List<Shipping> shippingList = service.getCustomerShippings(customerId);
		
		for (Shipping shipping : shippingList) {
			System.out.println(shipping.getShippingCompany());
		}
	}


	@Override
	public void uploadFile() {
		try{
			File file = new File(getFileName());
			uploadAction = new CustomerExcelUpload(file);
			List<Customer> customerList = (List<Customer>)uploadAction.upload(sheetIdx, startRow);
			service.saveAll(customerList);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public String add() {
		service.save(customer);
		return SUCCESS;
	}


	@Override
	public String edit() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
