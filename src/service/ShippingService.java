package service;

import java.util.Date;
import java.util.List;

import dao.hibernate.ShippingDao;
import utils.DateUtils;

public class ShippingService extends Service{

	
	public ShippingService(String type) {
		super(type);
	}
	
	@Override
	public void saveAll(Object objList) {
		// TODO Auto-generated method stub
	}

	@Override
	// find shipping detail by shipping id
	public List findBy(Object obj) {
		return null;
	}

	@Override
	public void update(Object obj) {
		
	}
	
	public double[][] getShippingAmountByWeek(List<Date> mondayList, List<Date> sundayList ,int numOfWeek) {
		double[][] data = new double[1][numOfWeek];
		for (int i = 0; i < numOfWeek; i ++) {
			System.out.println(DateUtils.parseDateToString(mondayList.get(i), "yyyy-MM-dd")+" - "+DateUtils.parseDateToString(sundayList.get(i), "yyyy-MM-dd"));
			data[0][i] = ((ShippingDao)dao).getShippingAmountByWeek(mondayList.get(i),sundayList.get(i));
		}
		return data;
	}

}
