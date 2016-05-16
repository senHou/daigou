package dao.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import po.Shipping;
import po.ShippingDetail;
import utils.HibernateUtil;

public class ShippingDetailDao extends HibernateDao {

	@Override
	public List findBy(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object object) {
		ShippingDetail shippingDetail = (ShippingDetail) find(ShippingDetail.class, ((ShippingDetail) object).getId());

		try {
			Shipping shipping = (Shipping) find(Shipping.class, ((ShippingDetail) object).getShippingNo());
			startOperation();
			double priceDifference = ((ShippingDetail) object).getQuantity() * ((ShippingDetail) object).getSoldPrice()
					- shippingDetail.getQuantity() * shippingDetail.getSoldPrice();

			shipping.setCost(shipping.getCost() + priceDifference);
			Set<ShippingDetail> shippingDetailSet = new HashSet<ShippingDetail>();
			shippingDetailSet.add(((ShippingDetail) object));
			shipping.setShippingDetailSet(shippingDetailSet);
			session.update(object);
			session.update(shipping);
			tx.commit();
		} catch (Exception e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}
	}

}
