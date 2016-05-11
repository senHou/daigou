package dao.hibernate;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import po.Customer;
import exception.DataAccessLayerException;
import utils.HibernateUtil;

public abstract class HibernateDao {

	protected Session session;
	protected Transaction tx;

	protected void startOperation() throws HibernateException {
		session = HibernateUtil.openSession();
		tx = session.beginTransaction();
	}

	public void save(Object obj) throws DataAccessLayerException{
		try {
			startOperation();
			System.out.println(obj);
			session.saveOrUpdate(obj);
			tx.commit();
		} catch (Exception e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}
	}

	public List findAll(Class clazz) {
		List objects = null;
		try {
			startOperation();
			Query query = session.createQuery("from " + clazz.getName());
			objects = query.list();
			tx.commit();
		} catch (Exception e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}
		return objects;
	}

	public Object find(Class clazz, Object id) {
		Object obj = null;
		try {
			startOperation();
			obj = session.get(clazz,(Serializable) id);
		} catch (Exception e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}
		return obj;
	}
	
	public void delete(Object object) {
		try {
			startOperation();
			session.delete(object);
		} catch (Exception e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}
	}

	protected void handleException(Exception e) throws DataAccessLayerException {
		HibernateUtil.rollback(tx);
		e.printStackTrace();
		throw new DataAccessLayerException(e);
	}
	
	public abstract List findBy(Object object);
}
