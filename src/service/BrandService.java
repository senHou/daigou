package service;

import java.util.List;

import org.apache.xmlbeans.impl.xb.ltgfmt.Code.Factory;

import dao.hibernate.HibernateDao;
import po.Brand;

public class BrandService extends Service{
	
	public BrandService(String type) {
		super(type);
	}
	
	@Override
	public void saveAll(Object objList) {
		List<Brand> brandList = (List<Brand>)objList;
		
		for (Brand brand : brandList) {
			List<Brand> tmp = findBy(brand.getName());
			
			if (tmp != null && tmp.size() > 0) {
				//do noting
			}else {
				save(brand);
			}
		}
	}

	@Override
	public List findBy(Object obj) {
		return dao.findBy(obj);
	}

}
