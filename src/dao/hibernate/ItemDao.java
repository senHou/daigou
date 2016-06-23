package dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import action.CommonAction;
import po.Item;
import po.Item;
import utils.HibernateUtil;
import utils.StringUtil;

public class ItemDao extends HibernateDao {

	// find item by item id
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

	public Item getItemByBrandIdAndItemName(int brandId, String itemName) {
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

	@Override
	public List findByPaging(Object object, int pageNo) throws Exception {
		Item item = (Item) object;
		List<Item> itemList = new ArrayList<Item>();
		try {
			startOperation();
			Criteria cr = session.createCriteria(Item.class, "item");

			if (item.getName() != null && !StringUtil.isEmpty(item.getName())) {
				cr.add(Restrictions.like("item.name", "%" + item.getName() + "%"));
			}
			
			if (item.getBrand() != null && item.getBrand().getId() != 0) {
				cr.add(Restrictions.eq("item.brand.id", item.getBrand().getId()));
			}
			cr.setFirstResult((pageNo - 1) * CommonAction.NUM_OF_ROW_PER_PAGE);
			cr.setMaxResults(CommonAction.NUM_OF_ROW_PER_PAGE);
			cr.addOrder(Order.desc("id"));
			itemList = cr.list();

		} catch (Exception e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}

		return itemList;
	}

	@Override
	public Integer findTotalRow(Object obj) throws Exception {
		Item item = (Item) obj;
		List<Item> itemList = new ArrayList<Item>();
		try {
			startOperation();
			Criteria cr = session.createCriteria(Item.class, "item").setProjection(Projections.rowCount());

			if (item.getName() != null && !StringUtil.isEmpty(item.getName())) {
				cr.add(Restrictions.like("item.name", "%" + item.getName() + "%"));
			}
			
			if (item.getBrand().getId() != 0) {
				cr.add(Restrictions.eq("item.brand.id", item.getBrand().getId()));
			}

			return Integer.parseInt(String.valueOf(cr.list().get(0)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			HibernateUtil.close(session);
		}

		return null;
	}

}
