package factory;

import dao.hibernate.CustomerDao;
import dao.hibernate.HibernateDao;
import dao.hibernate.ShippingDao;
import dao.hibernate.WeekOrderDetailDao;

public class DaoFactory {
	
	public final static String CUSTOMER = "CUSTOMER";
	public final static String SHIPPING ="SHIPPING";
	public final static String SHIPPING_COMPANY ="SHIPPING_COMPANY";
	public final static String WEEK_ORDER_DETAIL ="WEEK_ORDER_DETAIL";
	
	public static HibernateDao getDao(){
		return new HibernateDao();
	}
	
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
			return new HibernateDao();
		}
		
		if (daoType.equals(WEEK_ORDER_DETAIL)) {
			return new WeekOrderDetailDao();
		}
		
		return null;
	}
}
