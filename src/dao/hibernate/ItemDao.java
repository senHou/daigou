package dao.hibernate;

import java.util.List;

import org.hibernate.Query;

import po.Item;

public class ItemDao extends HibernateDao{

	@Override
	// find item by brand id
	public List<Item> findBy(Object object) {
		// TODO Auto-generated method stub
		startOperation();
		String hql = "from Item where brand.id=:id order by id";
		Query query = session.createQuery(hql);
		query.setString("id", (String)object);
		List<Item> itemList = (List<Item>)query.list();
		return itemList;
	}

}
