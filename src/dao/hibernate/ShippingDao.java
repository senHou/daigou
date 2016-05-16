package dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import po.ShippingDetail;

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
}
