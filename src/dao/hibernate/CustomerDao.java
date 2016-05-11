package dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import po.Shipping;

public class CustomerDao extends HibernateDao{

	public CustomerDao(){}
	
	
	public List<Shipping> getCustomerShippings(String customerId){
		startOperation();
		String hql = "from Shipping as s where s.customer.id = :customer_id";
		Query query = session.createQuery(hql);
		query.setParameter("customer_id", customerId);
		List<Shipping> shippings = (List<Shipping>)query.list();
		return shippings;
	}


	@Override
	public List findBy(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}
