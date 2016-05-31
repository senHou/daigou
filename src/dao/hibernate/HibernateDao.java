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

public  class HibernateDao {

	protected Session session;
	protected Transaction tx;

	protected void startOperation() throws HibernateException {
		session = HibernateUtil.openSession();
		tx = session.beginTransaction();
	}

	public void save(Object obj) throws DataAccessLayerException{
		try {
			startOperation();
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
			tx.commit();
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
	
	
	public  List findAllOrderBy(Class clazz, Object obj, String type) {
		List list = null;
		
		try {
			startOperation();
			String hql = "from "+clazz.getName()+" order by "+String.valueOf(obj)+" "+type;
			Query query = session.createQuery(hql);
			list = query.list();
		}catch(Exception e) {
			handleException(e);
		}finally {
			HibernateUtil.close(session);
		}
		return list;
	}
	
	public void saveAll(List list) {
		try {
			startOperation();
			for (int i = 0; i < list.size(); i ++) {
				session.save(list.get(i));
				if( i % 50 == 0 ) { 
			        session.flush();
			        session.clear();
			    }
			}
			tx.commit();
		} catch (Exception e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}
	}
	
	public void update(Object object) {
		try {
			startOperation();
			session.update(object);
			tx.commit();
		} catch (Exception e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}
	}
	
	public List findByPaging(Object object, int pageNo) {
		return null;
	}
	
	public Integer findTotalRow(Class clazz) {
		
		try {
			startOperation();
			String sql = "select count(*) from "+clazz.getName();
			
			Query query = session.createQuery(sql);
			return Integer.parseInt(String.valueOf(query.list().get(0)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}
		
		return null;
	}
}
