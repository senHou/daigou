package dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import action.CommonAction;
import po.Brand;
import po.Customer;
import po.Shipping;
import utils.HibernateUtil;
import utils.StringUtil;

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
	
	@Override
	public List findByPaging(Object object, int pageNo) throws Exception {
		Customer customer = (Customer) object;
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			startOperation();
			Criteria cr = session.createCriteria(Customer.class, "customer");
			
			if (!StringUtil.isEmpty(customer.getId())) {
				cr.add(Restrictions.eq("customer.id", customer.getId()));
			}

			if (customer.getName() != null && !StringUtil.isEmpty(customer.getName())) {
				cr.add(Restrictions.like("customer.name", "%" + customer.getName() + "%"));
			}

			
			cr.setFirstResult((pageNo - 1) * CommonAction.NUM_OF_ROW_PER_PAGE);
			cr.setMaxResults(CommonAction.NUM_OF_ROW_PER_PAGE);
			cr.addOrder(Order.desc("id"));
			
			customerList = cr.list();

		} catch (Exception e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}

		return customerList;
	}
	
	@Override
	public Integer findTotalRow(Object obj) throws Exception {
		Customer customer = (Customer) obj;
		try {
			startOperation();
			Criteria cr = session.createCriteria(Customer.class, "customer").setProjection(Projections.rowCount());

			if (!StringUtil.isEmpty(customer.getId())) {
				cr.add(Restrictions.eq("customer.id", customer.getId()));
			}
			
			if (customer.getName() != null && !StringUtil.isEmpty(customer.getName())) {
				cr.add(Restrictions.like("customer.name", "%" + customer.getName() + "%"));
			}

			return Integer.parseInt(String.valueOf(cr.list().get(0)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}

		return null;
	}
	
	public void update(Object object, String oldCustomerId) {
		Customer customer = (Customer) object;
		try {
			startOperation();
			String hql = "update Customer set id=:id, name=:name where id=:oldCustomerId";
			Query query = session.createQuery(hql);
			query.setString("id", customer.getId());
			query.setString("name", customer.getName());
			query.setString("oldCustomerId", oldCustomerId);
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}
	}
}
