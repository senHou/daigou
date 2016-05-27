package action;

import java.io.File;
import java.util.List;

import excel.CustomerExcelUpload;
import excel.ExcelUpload;
import exception.DataAccessLayerException;
import factory.DaoFactory;
import po.Customer;
import po.Shipping;
import service.CustomerService;

public class CustomerAction extends FileUploadAction{

	private CustomerService service;
	private ExcelUpload uploadAction;
	private Customer customer;
	
	public CustomerAction(){
		super();
		service = new CustomerService();
		this.startRow = 0;
	}
	
	
	public void getShippings(String customerId) {
		List<Shipping> shippingList = service.getCustomerShippings(customerId);
		
		for (Shipping shipping : shippingList) {
			System.out.println(shipping.getShippingCompany());
		}
	}


	@Override
	public String uploadFile() {
		try{
			File file = new File(getFileName());
			uploadAction = new CustomerExcelUpload(file);
			List<Customer> customerList = (List<Customer>)uploadAction.upload(sheetIdx, startRow);
			service.saveAll(customerList);
			setErrorMessage(null);
			return SUCCESS;
		}catch(Exception e) {
			e.printStackTrace();
			setErrorMessage("upload customer error");
			return ERROR;
		}
	}


	@Override
	public String add() {
		try {
			service.save(customer);
			setErrorMessage(null);
			return SUCCESS;
		}catch(DataAccessLayerException e) {
			setErrorMessage("Add customer error");
			return ERROR;
		}
		
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


	@Override
	public String list() {
		// TODO Auto-generated method stub
		return null;
	}
}
