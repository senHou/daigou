package service;

import java.util.List;

public class ItemService extends Service{

	public ItemService(String type) {
		super(type);
	}

	@Override
	public void saveAll(Object objList) {
		
	}

	@Override
	//find item by brand
	public List findBy(Object obj) {
		return dao.findBy(obj);
	}

	@Override
	public void update(Object obj) {
		
	}

}
