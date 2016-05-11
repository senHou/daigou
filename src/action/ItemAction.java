package action;

import java.util.List;

import factory.DaoFactory;
import po.Brand;
import po.Item;
import service.ItemService;
import service.Service;
import utils.HtmlUtils;

public class ItemAction extends CommonAction{
	
	private Service service;
	private String brandId;
	private Item item;
	private List<Brand> brandList;
	
	public ItemAction() {
		super();
		service = new ItemService(DaoFactory.ITEM);
	}
	
	public void printOptions(){
		List<Item> itemList = service.findBy(brandId);
		StringBuffer option = new StringBuffer();
		for (Item item : itemList) {
			option.append(HtmlUtils.genreateOption(item.getName(), String.valueOf(item.getId())));
		}
		System.out.println(option.toString());
		writeToHtml(option.toString());
	}

	@Override
	public String add() {

		return SUCCESS;
	}
	
	public String initAdd() {
		if (dataManager.getDataMap().get(CommonAction.BRAND_LIST) != null) {
			brandList = dataManager.getDataMap().get(CommonAction.BRAND_LIST);
		}else {
			brandList = service.getAll(Brand.class);
			dataManager.getDataMap().put(CommonAction.BRAND_LIST, brandList);
		}
		 
		return SUCCESS;
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
}
