package service;

import java.util.List;

import dao.hibernate.HibernateDao;
import exception.DataAccessLayerException;
import factory.DaoFactory;

public abstract class Service {

	protected HibernateDao dao;
	
	public Service(String type){
		dao = DaoFactory.getDao(type);
	}
	
	public List getAll(Class clazz){
		return dao.findAll(clazz);
	}
	
	public Object get(Class clazz, Object id) {
		return dao.find(clazz, id);
	}
	
	public void save(Object o) throws DataAccessLayerException{
		dao.save(o);
	}
	
	public void delete(Object o) {
		
	}
	
	public abstract void saveAll(Object objList);
	
	public abstract List findBy(Object obj);
}
