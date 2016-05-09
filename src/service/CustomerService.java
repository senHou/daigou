package service;

import java.util.List;

import dao.hibernate.CustomerDao;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List findBy(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
}
