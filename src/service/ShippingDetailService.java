package service;

import java.util.List;

import po.ShippingDetail;

public class ShippingDetailService extends Service{

	public ShippingDetailService(String type) {
		super(type);
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
