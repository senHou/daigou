package dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import po.Brand;
import utils.HibernateUtil;

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
}
