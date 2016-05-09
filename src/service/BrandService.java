package service;

import java.util.List;

import org.apache.xmlbeans.impl.xb.ltgfmt.Code.Factory;

import dao.hibernate.HibernateDao;

public class BrandService extends Service{
	
	public BrandService(String type) {
		super(type);
	}
	
	@Override
	public void saveAll(Object objList) {
		dao.saveAll(objList);
	}

	@Override
	public List findBy(Object obj) {
		return dao.findBy(obj);
	}

}
