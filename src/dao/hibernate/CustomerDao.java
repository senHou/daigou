package dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import po.Customer;
import po.Shipping;
import utils.HibernateUtil;

public class CustomerDao extends HibernateDao{

	public CustomerDao(){}
	
	// find customer's shipping info
	public List<Shipping> getCustomerShippings(String customerId){
		List<Shipping> shippings = null;
		try {
			startOperation();
			String hql = "from Shipping as s where s.customer.id = :customer_id";
			Query query = session.createQuery(hql);
			query.setParameter("customer_id", customerId);
			shippings = (List<Shipping>)query.list();
		}catch(Exception e) {
			HibernateUtil.close(session);
		}
		return shippings;
	}

	public List findByName(Object object) {
		
		return null;
	}
}
