package service;

import java.util.ArrayList;
import java.util.List;

import dao.hibernate.CustomerDao;
import dao.hibernate.ShippingDao;
import factory.DaoFactory;
import po.Customer;
import po.Shipping;

public class CustomerService extends Service{
	
	public CustomerService() {
		super(DaoFactory.CUSTOMER);
	}
	
	public List<Shipping> getCustomerShippings(String customerId) {
		return ((CustomerDao)dao).getCustomerShippings(customerId);
	}

	@Override
	public void saveAll(List objList) {
		List<Customer> customerList = (List<Customer>)objList;
		List<Customer> newList = new ArrayList<Customer>();
		for (Customer customer : customerList) {
			if (get(Customer.class, customer.getId()) == null) {
				newList.add(customer);
			}
		}
		
		super.saveAll(newList);
	}
	
	public int findTotalRow(Object object) throws Exception{
		return dao.findTotalRow(object);
	}
	
	public void update(Object object, boolean isCustomerIdChanged, String oldCustomerId) {
		if (!isCustomerIdChanged) {
			super.save(object);
		} else {
			((CustomerDao) dao).update(object,oldCustomerId);
		}
	}
}
