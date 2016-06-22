package dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import action.CommonAction;
import po.Brand;
import po.Shipping;
import utils.HibernateUtil;
import utils.StringUtil;

public class BrandDao extends HibernateDao{

	public List<Brand> findByName(String name) {
		List<Brand> brandList = null;
		try {
			startOperation();
			String hql = "from Brand where name =:name";
			Query query = session.createQuery(hql);
			query.setString("name", name);
			brandList = query.list();
		}catch (Exception e) {
			handleException(e);
		}finally {
			HibernateUtil.close(session);
		}
		
		return brandList;
	}
	
	@Override
	public List findByPaging(Object object, int pageNo) throws Exception {
		Brand brand = (Brand) object;
		List<Brand> shippingList = new ArrayList<Brand>();
		try {
			startOperation();
			Criteria cr = session.createCriteria(Brand.class, "brand");


			if (brand.getName() != null && !StringUtil.isEmpty(brand.getName())) {
				cr.add(Restrictions.like("brand.name", "%" + brand.getName() + "%"));
			}
			cr.setFirstResult((pageNo - 1) * CommonAction.NUM_OF_ROW_PER_PAGE);
			cr.setMaxResults(CommonAction.NUM_OF_ROW_PER_PAGE);
			cr.addOrder(Order.desc("id"));
			shippingList = cr.list();

		} catch (Exception e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}

		return shippingList;
	}
	
	@Override
	public Integer findTotalRow(Object obj) throws Exception {
		Brand brand = (Brand) obj;
		List<Brand> shippingList = new ArrayList<Brand>();
		try {
			startOperation();
			Criteria cr = session.createCriteria(Brand.class, "brand").setProjection(Projections.rowCount());


			if (brand.getName() != null && !StringUtil.isEmpty(brand.getName())) {
				cr.add(Restrictions.like("brand.name", "%" + brand.getName() + "%"));
			}

			return Integer.parseInt(String.valueOf(cr.list().get(0)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}

		return null;
	}
}
