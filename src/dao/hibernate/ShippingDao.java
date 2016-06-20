package dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import action.CommonAction;
import po.Customer;
import po.Shipping;
import po.ShippingCompany;
import po.ShippingDetail;
import utils.HibernateUtil;
import utils.StringUtil;

public class ShippingDao extends HibernateDao {

	public List findShippingDetailByShippingNo(String shippingNo) {
		try{
			startOperation();
			String hql = "from ShippingDetail as s where s.shippingNo = :shipping_no";
			Query query = session.createQuery(hql);
			query.setParameter("shipping_no", shippingNo);
			List<ShippingDetail> shippings = (List<ShippingDetail>) query.list();
			return shippings;
		}catch(Exception e) {
			handleException(e);
			return null;
		}finally {
			HibernateUtil.close(session);
		}
	}

	public double getShippingAmountByWeek(Date startDate, Date endDate) {
		try {
			startOperation();
			Criteria cr = session.createCriteria(Shipping.class);
			cr.add(Restrictions.between("date", startDate, endDate));
			cr.setProjection(Projections.sum("cost"));
			List list = cr.list();

			if (list == null || list.get(0) == null) {
				return 0;
			} else {
				return (double) list.get(0);
			}
		} catch (Exception e) {
			handleException(e);
			return 0;
		} finally {
			HibernateUtil.close(session);
		}
	}

	@Override
	public List findByPaging(Object object, int pageNo) throws Exception {
		Shipping shipping = (Shipping) object;
		List<Shipping> shippingList = new ArrayList<Shipping>();
		try {
			startOperation();
			Criteria cr = session.createCriteria(Shipping.class, "shipping");
			cr.createAlias("shipping.customer", "customer");

			if (!StringUtil.isEmpty(shipping.getShippingNo())) {
				cr.add(Restrictions.eq("shippingNo", shipping.getShippingNo()));
			} else {
				cr.setFirstResult((pageNo - 1) * CommonAction.NUM_OF_ROW_PER_PAGE);
				cr.setMaxResults(CommonAction.NUM_OF_ROW_PER_PAGE);
			}

			if (shipping.getDate() != null) {
				cr.add(Restrictions.le("date", shipping.getDate()));
			}

			if (shipping.getCustomer() != null && !StringUtil.isEmpty(shipping.getCustomer().getName())) {
				cr.add(Restrictions.like("customer.name", "%" + shipping.getCustomer().getName() + "%"));
			}

			cr.addOrder(Order.desc("date"));
			cr.addOrder(Order.asc("shippingNo"));

			shippingList = cr.list();

		} catch (Exception e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}

		return shippingList;
	}

	public Integer findTotalRow(Object obj) throws Exception {
		try {
			Shipping shipping = (Shipping) obj;
			startOperation();
			Criteria cr = session.createCriteria(Shipping.class, "shipping").setProjection(Projections.rowCount());
			cr.createAlias("shipping.customer", "customer");

			if (!StringUtil.isEmpty(shipping.getShippingNo())) {
				cr.add(Restrictions.eq("shippingNo", shipping.getShippingNo()));
			}

			if (shipping.getDate() != null) {
				cr.add(Restrictions.le("date", shipping.getDate()));
			}

			if (shipping.getCustomer() != null && !StringUtil.isEmpty(shipping.getCustomer().getName())) {
				cr.add(Restrictions.like("customer.name", "%" + shipping.getCustomer().getName() + "%"));
			}
			return Integer.parseInt(String.valueOf(cr.list().get(0)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}
		return null;
	}

	/**
	 * 
	 * @param object
	 * @param isShippingNoChanged
	 *            if shippingNo not changed, call update from superclass,
	 *            otherwise, using this method
	 */
	public void update(Object object, String oldShippingNo) {
		Shipping shipping = (Shipping) object;
		try {
			startOperation();
			String hql = "update Shipping set shippingNo = :shipping_no, date = :date, customer.id = :id, "
					+ "phoneNumber = :phoneNumber, address = :address, shippingCompany.id = :shippingCompanyId,"
					+ "agent = :agent where shippingNo = :oldShippingNo";
			Query query = session.createQuery(hql);
			query.setString("shipping_no", shipping.getShippingNo());
			query.setDate("date", shipping.getDate());
			query.setString("id", shipping.getCustomer().getId());
			query.setString("phoneNumber", shipping.getPhoneNumber());
			query.setString("address", shipping.getAddress());
			query.setInteger("shippingCompanyId", shipping.getShippingCompany().getId());
			query.setString("agent", shipping.getAgent());
			query.setString("oldShippingNo", oldShippingNo);
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}
	}
}
