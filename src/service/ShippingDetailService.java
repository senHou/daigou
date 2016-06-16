package service;

import dao.hibernate.ShippingDetailDao;
import factory.DaoFactory;
import po.ShippingDetail;

public class ShippingDetailService extends Service{

	public ShippingDetailService() {
		super(DaoFactory.SHIPPING_DETAIL);
	}

	@Override
	public void update(Object object) {
		ShippingDetail shippingDetail = (ShippingDetail) get(ShippingDetail.class, ((ShippingDetail) object).getId());

		if (((ShippingDetail) object).getQuantity() == shippingDetail.getQuantity()
				&& ((ShippingDetail) object).getSoldPrice() == shippingDetail.getSoldPrice()) {
			save(object);
		} else {
			dao.update(object);
		}
	}

}
