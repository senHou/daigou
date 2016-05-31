package dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import action.CommonAction;
import po.Shipping;
import po.ShippingDetail;
import utils.HibernateUtil;
import utils.StringUtil;

public class ShippingDao extends HibernateDao {

	public List findByShippingNo(String shippingNo) {
		startOperation();
		String hql = "from ShippingDetail as s where s.shipping_no = :shipping_no";
		Query query = session.createQuery(hql);
		query.setParameter("shipping_no", shippingNo);
		List<ShippingDetail> shippings = (List<ShippingDetail>)query.list();
		return shippings;
	}
	
	public double getShippingAmountByWeek(Date startDate, Date endDate) {
		try {
			startOperation();
			Criteria cr = session.createCriteria(Shipping.class);
			cr.add(Restrictions.between("date", startDate, endDate));
			cr.setProjection(Projections.sum("cost"));
			List list = cr.list();
			
			if (list == null || list.get(0) == null) {
				return 0;
			}else {
				return (double)list.get(0);
			}
		} catch (Exception e) {
			handleException(e);
			return 0;
		} finally {
			HibernateUtil.close(session);
		}
	}

	@Override
	public List findByPaging(Object object, int pageNo) {
		Shipping shipping = (Shipping)object;
		List<Shipping> shippingList = new ArrayList<Shipping>();
		try {
			startOperation();
			Criteria cr = session.createCriteria(Shipping.class,"shipping");
			cr.createAlias("shipping.customer","customer");
			
			if (!StringUtil.isEmpty(shipping.getShippingNo())){
				cr.add(Restrictions.eq("shippingNo", shipping.getShippingNo()));
			}else {
				cr.setFirstResult((pageNo - 1) * CommonAction.NUM_OF_ROW_PER_PAGE);
			    cr.setMaxResults(CommonAction.NUM_OF_ROW_PER_PAGE);
			}
			
			if (shipping.getDate() != null) {
				cr.add(Restrictions.le("date", shipping.getDate()));
			}
			
			if (!StringUtil.isEmpty(shipping.getCustomer().getName())) {
				cr.add(Restrictions.like("customer.name", "%"+shipping.getCustomer().getName()+"%"));
			}
			
			cr.addOrder(Order.desc("date"));
			
		    shippingList = cr.list();
		    
		}catch (Exception e) {
			
		}finally {
			HibernateUtil.close(session);
		}
		
		return shippingList;
	}

	
}
