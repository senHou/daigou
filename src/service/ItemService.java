package service;

import java.util.List;

public class ItemService extends Service{

	public ItemService(String type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveAll(Object objList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List findBy(Object obj) {
		return dao.findBy(obj);
	}

}
