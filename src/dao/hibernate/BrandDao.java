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

	@Override
	public void saveAll(Object object) {
		List<Brand> brandList = (List<Brand>)object;
		
		for (Brand brand : brandList) {
			List<Brand> tmp = findBy(brand.getName());
			
			if (tmp != null && tmp.size() > 0) {
				//do noting
			}else {
				save(brand);
			}
		}
		
	}
	
	
}
