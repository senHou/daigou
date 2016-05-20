package dao.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import po.Shipping;
import po.ShippingDetail;
import utils.DateUtils;
import utils.HibernateUtil;

public class ShippingDao extends HibernateDao {

	@Override
	public List findBy(Object object) {
		startOperation();
		String hql = "from ShippingDetail as s where s.shipping_no = :shipping_no";
		Query query = session.createQuery(hql);
		query.setParameter("shipping_no", object);
		List<ShippingDetail> shippings = (List<ShippingDetail>)query.list();
		return shippings;
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}
	
	public double getShippingAmountByWeek(Date startDate, Date endDate) {
		try {
			startOperation();
			Criteria cr = session.createCriteria(Shipping.class);
			cr.add(Restrictions.between("date", startDate, endDate));
			cr.setProjection(Projections.sum("cost"));
			List list = cr.list();
			
			if (list == null || list.size() == 0) {
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
}
