package service;

import java.util.ArrayList;
import java.util.List;

import dao.hibernate.WeekOrderDetailDao;
import factory.DaoFactory;
import po.WeekOrderDetail;

public class WeekOrderDetailService extends Service{
	
	WeekOrderDetailDao orderDao;
	
	public WeekOrderDetailService() {
		super(DaoFactory.WEEK_ORDER_DETAIL);
		orderDao = (WeekOrderDetailDao)dao;
	}
	
	public void updateQuantity(WeekOrderDetail orderDetail) {
		orderDao.updateQuantity(orderDetail);
	}

	@Override
	public void saveAll(List objList) {
		List<WeekOrderDetail> weekOrderDetailList = (List<WeekOrderDetail>)objList;
		for (WeekOrderDetail weekOrderDetail : weekOrderDetailList) {
			WeekOrderDetail tmp = (WeekOrderDetail)get(WeekOrderDetail.class,weekOrderDetail);
			if (tmp == null) {
				save(weekOrderDetail);
			}else {
				int newQuantity = weekOrderDetail.getQuantity() + tmp.getQuantity();
				weekOrderDetail.setQuantity(newQuantity);
				updateQuantity(weekOrderDetail);
			}
		}
	}
}
