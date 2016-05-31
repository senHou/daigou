package action;

import java.util.ArrayList;
import java.util.List;

import factory.DaoFactory;
import po.Brand;
import po.Item;
import service.ItemService;
import service.Service;
import utils.HtmlUtils;
import utils.StringUtil;

public class ItemAction extends CommonAction{
	
	private ItemService service;
	private String brandId;
	private Item item;
	private List<Brand> brandList;
	private List<Item> itemList;
	
	public ItemAction() {
		super();
		service = new ItemService();
	}
	
	public void printOptions(){
		List<Item> itemList = service.findByBrandId(brandId);
		StringBuffer option = new StringBuffer();
		for (Item item : itemList) {
			option.append(HtmlUtils.genreateOption(item.getName(), String.valueOf(item.getId())));
		}
		System.out.println(option.toString());
		writeToHtml(option.toString());
	}

	@Override
	public String add() {
		try {
			service.save(item);
			setErrorMessage(null);
			return SUCCESS;
		}catch(Exception e) {
			setErrorMessage("add item error");
			return ERROR;
		}
	}
	
	public String initAdd() {
		loadBrandList();
		return SUCCESS;
	}
	
	private void loadBrandList() {
		if (dataManager.getDataMap().get(CommonAction.BRAND_LIST) != null) {
			brandList = dataManager.getDataMap().get(CommonAction.BRAND_LIST);
		}else {
			brandList = service.getAll(Brand.class);
			dataManager.getDataMap().put(CommonAction.BRAND_LIST, brandList);
		}
	}

	@Override
	public String edit() {
		return null;
	}
	
	public String getBrandId() {
		return brandId;
	}
	
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public List<Brand> getBrandList() {
		return brandList;
	}
	
	public void setBrandList(List<Brand> brandList) {
		this.brandList = brandList;
	}
	
	public List<Item> getItemList() {
		return itemList;
	}

	@Override
	public String list() {
		itemList = new ArrayList<Item>();
		loadBrandList();
		if (StringUtil.isEmpty(brandId)) {
			itemList = service.getAll(Item.class);
		}else {
			itemList = service.findByBrandId(brandId);
		}
		return SUCCESS;
	}

	@Override
	public List listByPaging() {
		// TODO Auto-generated method stub
		return null;
	}
}
