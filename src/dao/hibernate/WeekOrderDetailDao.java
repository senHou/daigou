package dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import po.WeekOrderDetail;
import utils.HibernateUtil;

public class WeekOrderDetailDao extends HibernateDao {

	public void updateQuantity(WeekOrderDetail weekOrderDetail) {
		try {
			startOperation();
			String hql = "update WeekOrderDetail set quantity = :quantity where itemId = :itemId and year =:year and weekNo =:weekNo";
			Query query = session.createQuery(hql);
			query.setInteger("quantity", weekOrderDetail.getQuantity());
			query.setInteger("itemId", weekOrderDetail.getItemId());
			query.setInteger("year", weekOrderDetail.getYear());
			query.setInteger("weekNo", weekOrderDetail.getWeekNo());
			int rowCount = query.executeUpdate();
			System.out.println(rowCount+" row(s) updated");
			tx.commit();
		} catch (Exception e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}
	}

	@Override
	public List findBy(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAll(Object object) {
		// TODO Auto-generated method stub
		
	}
}
