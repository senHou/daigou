package factory;

import dao.hibernate.BrandDao;
import dao.hibernate.CustomerDao;
import dao.hibernate.HibernateDao;
import dao.hibernate.ItemDao;
import dao.hibernate.ShippingCompanyDao;
import dao.hibernate.ShippingDao;
import dao.hibernate.ShippingDetailDao;
import dao.hibernate.WeekOrderDetailDao;

public class DaoFactory {
	
	public final static String CUSTOMER = "CUSTOMER";
	public final static String SHIPPING ="SHIPPING";
	public final static String SHIPPING_COMPANY ="SHIPPING_COMPANY";
	public final static String WEEK_ORDER_DETAIL ="WEEK_ORDER_DETAIL";
	public final static String SHIPPING_DETAIL = "SHIPPING_DETAIL";
	public final static String BRAND = "BRAND";
	public final static String ITEM = "ITEM";
	
	public static HibernateDao getDao(String daoType){
		
		if (daoType == null) {
			return null;
		}
		
		if (daoType.equals(CUSTOMER)){
			return new CustomerDao();
		}
		
		if (daoType.equals(SHIPPING)){
			return new ShippingDao();
		}
		
		if (daoType.equals(SHIPPING_COMPANY)){
			return new ShippingCompanyDao();
		}
		
		if (daoType.equals(WEEK_ORDER_DETAIL)) {
			return new WeekOrderDetailDao();
		}
		
		if (daoType.equals(SHIPPING_DETAIL)) {
			return new ShippingDetailDao();
		}
		
		if (daoType.equals(BRAND)) {
			return new BrandDao();
		}
		
		if (daoType.equals(ITEM)) {
			return new ItemDao();
		}
		
		return null;
	}
}
