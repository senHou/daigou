package service;

import java.util.ArrayList;
import java.util.List;

import dao.hibernate.BrandDao;
import factory.DaoFactory;
import po.Brand;

public class BrandService extends Service{
	
	public BrandService() {
		super(DaoFactory.BRAND);
	}
	
	@Override
	public void saveAll(List objList) {
		List<Brand> brandList = (List<Brand>)objList;
		List<Brand> newList = new ArrayList<Brand>();
		for (Brand brand : brandList) {
			List<Brand> tmp = findByName(brand.getName());
			
			if (tmp != null && tmp.size() > 0) {
			}else {
				newList.add(brand);
			}
		}
		
		super.saveAll(newList);
	}

	public List findByName(String name) {
		return ((BrandDao)dao).findByName(name);
	}
	
	public int findTotalRow(Object object) throws Exception{
		return dao.findTotalRow(object);
	}
}
