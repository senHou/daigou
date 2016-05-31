package service;

import java.util.List;

import dao.hibernate.ItemDao;
import factory.DaoFactory;
import po.Item;

public class ItemService extends Service{

	public ItemService() {
		super(DaoFactory.ITEM);
	}

	@Override
	public void saveAll(List objList) {
		
	}

	public List findByBrandId(Object obj) {
		return ((ItemDao) dao).findByBrandId(obj);
	}
	
	public Item getItemByBrandIdAandItemName(int brandId, String itemName) {
		return ((ItemDao) dao).getItemByBrandIdAandItemName(brandId, itemName);
	}
}
