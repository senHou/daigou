package service;

import java.util.List;

import dao.hibernate.CustomerDao;
import po.Customer;
import po.Shipping;

public class CustomerService extends Service{
	
	public CustomerService(String type) {
		super(type);
	}
	
	public List<Shipping> getCustomerShippings(String customerId) {
		return ((CustomerDao)dao).getCustomerShippings(customerId);
	}

	@Override
	public void saveAll(Object objList) {
		List<Customer> customerList = (List<Customer>)objList;
		for (Customer customer : customerList) {
			if (get(Customer.class, customer.getId()) == null) {
				save(customer);
			}
		}
	}

	@Override
	public List findBy(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		
	}
}
