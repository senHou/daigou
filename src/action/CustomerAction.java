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
import utils.HtmlUtils;

public class CustomerAction extends FileUploadAction{

	private ExcelUpload uploadAction;
	private Customer customer;
	private String originCustomerId;
	
	public CustomerAction(){
		super();
		service = new CustomerService();
		this.startRow = 0;
	}
	
	
	public void getShippings(String customerId) {
		List<Shipping> shippingList = ((CustomerService)service).getCustomerShippings(customerId);
		
		for (Shipping shipping : shippingList) {
			System.out.println(shipping.getShippingCompany());
		}
	}


//	@Override
//	public String uploadFile() {
//		try{
//			File file = new File(getFileName());
//			uploadAction = new CustomerExcelUpload(file);
//			List<Customer> customerList = (List<Customer>)uploadAction.upload(sheetIdx, startRow);
//			service.saveAll(customerList);
//			setErrorMessage(null);
//			return SUCCESS;
//		}catch(Exception e) {
//			e.printStackTrace();
//			setErrorMessage("upload customer error");
//			return ERROR;
//		}
//	}


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
	


	
	public String initEdit(){
		customer = (Customer)service.get(Customer.class, customer.getId());
		return super.initEdit();
	}

	@Override
	public String edit(){
		try {
			((CustomerService)service).update(customer, !customer.getId().equalsIgnoreCase(originCustomerId), originCustomerId);
			return SUCCESS;
		}catch(Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getOriginCustomerId() {
		return originCustomerId;
	}
	
	public void setOriginCustomerId(String originCustomerId) {
		this.originCustomerId = originCustomerId;
	}
	

	@Override
	public String list() {
		
		try {
			if (customer == null) {
				customer = new Customer();
			}

			int maxRow = service.findTotalRow(customer);
			maxPage = maxRow % NUM_OF_ROW_PER_PAGE == 0 ? maxRow / NUM_OF_ROW_PER_PAGE
					: maxRow / NUM_OF_ROW_PER_PAGE + 1;

			customerList = service.findByPaging(customer, pageNo);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}


	@Override
	public void ajaxListByPage() {
		try {

			if (customer == null) {
				customer = new Customer();
			}
			int maxRow = service.findTotalRow(customer);

			maxPage = maxRow % NUM_OF_ROW_PER_PAGE == 0 ? maxRow / NUM_OF_ROW_PER_PAGE
					: maxRow / NUM_OF_ROW_PER_PAGE + 1;

			customerList = service.findByPaging(customer, pageNo);

			writeToHtml(HtmlUtils.generateCustomerSearchResult(customerList));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
