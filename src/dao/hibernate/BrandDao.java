package dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import po.Brand;

public class BrandDao extends HibernateDao{

	@Override
	public List<Brand> findBy(Object object) {
		startOperation();
		String hql = "from Brand where name =:name";
		Query query = session.createQuery(hql);
		query.setString("name", (String)object);
		List<Brand> brandList = query.list();
		return brandList;
	}
}
