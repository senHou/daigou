package service;

import java.util.List;

import dao.hibernate.HibernateDao;
import exception.DataAccessLayerException;
import factory.DaoFactory;

public abstract class Service {

	protected HibernateDao dao;

	public Service() {
		dao = new HibernateDao();
	}
	
	public Service(String type) {
		dao = DaoFactory.getDao(type);
	}

	public List getAll(Class clazz) throws DataAccessLayerException {
		return dao.findAll(clazz);
	}

	public Object get(Class clazz, Object id) throws DataAccessLayerException {
		return dao.find(clazz, id);
	}

	public void save(Object o) throws DataAccessLayerException {
		dao.save(o);
	}

	public void delete(Object o) {
		
	}

	public  void saveAll(List objList) {
		dao.saveAll(objList);
	}

	public void update(Object obj) throws DataAccessLayerException {
		dao.update(obj);
	}
}
