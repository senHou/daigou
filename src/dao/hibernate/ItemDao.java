package dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import po.Item;
import utils.HibernateUtil;

public class ItemDao extends HibernateDao{

	// find item by brand id
	public List<Item> findByBrandId(Object object) {
		List<Item> itemList = null;
		try {
			startOperation();
			String hql = "from Item where brand.id=:id order by id";
			Query query = session.createQuery(hql);
			query.setString("id", (String)object);
			itemList = (List<Item>)query.list();
		}catch (Exception e) {
			handleException(e);
		}finally {
			HibernateUtil.close(session);
		}
		return itemList;
	}
	
	public Item getItemByBrandIdAandItemName(int brandId, String itemName) {
		Item item = null;
		
		try {
			startOperation();
			String hql = "from Item where brand.id=:id and name=:name";
			Query query = session.createQuery(hql);
			query.setString("id", String.valueOf(brandId));
			query.setString("name", itemName);
			item = (Item)query.list().get(0);
			
		}catch (Exception e) {
			handleException(e);
		}finally {
			HibernateUtil.close(session);
		}
		
		return item;
	}
}
