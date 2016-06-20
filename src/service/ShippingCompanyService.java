package service;

import java.util.List;

import dao.hibernate.ShippingCompanyDao;
import factory.DaoFactory;
import po.ShippingCompany;

public class ShippingCompanyService extends Service {

	public ShippingCompanyService() {
		super(DaoFactory.SHIPPING_COMPANY);
	}

	public List<ShippingCompany> search(ShippingCompany shippingCompany) {
		return ((ShippingCompanyDao) dao).search(shippingCompany);
	}
}
