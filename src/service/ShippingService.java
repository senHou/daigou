package service;

import java.util.Date;
import java.util.List;

import dao.hibernate.ShippingDao;
import factory.DaoFactory;
import utils.DateUtils;

public class ShippingService extends Service{

	public ShippingService() {
		super(DaoFactory.SHIPPING);
	}

	public double[][] getShippingAmountByWeek(List<Date> mondayList, List<Date> sundayList ,int numOfWeek) {
		double[][] data = new double[1][numOfWeek];
		for (int i = 0; i < numOfWeek; i ++) {
			System.out.println(DateUtils.parseDateToString(mondayList.get(i), "yyyy-MM-dd")+" - "+DateUtils.parseDateToString(sundayList.get(i), "yyyy-MM-dd"));
			data[0][i] = ((ShippingDao)dao).getShippingAmountByWeek(mondayList.get(i),sundayList.get(i));
		}
		return data;
	}

	public int findTotalRow(Object object) throws Exception{
		return dao.findTotalRow(object);
	}
	
	public List findShippingDetailByShippingNo(String shippingNo) {
		if (shippingNo != null) {
			return ((ShippingDao) dao).findShippingDetailByShippingNo(shippingNo);
		}else {
			return null;
		}
	}
}
