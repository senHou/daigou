package action;

import java.util.ArrayList;
import java.util.List;

import factory.DaoFactory;
import po.Brand;
import po.Item;
import po.Shipping;
import service.ItemService;
import service.Service;
import utils.HtmlUtils;
import utils.StringUtil;

public class ItemAction extends CommonAction {

	private ItemService service;
	private String brandId;
	private Item item;
	private List<Item> itemList;

	public ItemAction() {
		super();
		service = new ItemService();
	}

	public void printOptions() {
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
			return super.add();
		} catch (Exception e) {
			setErrorMessage("add item error");
			return ERROR;
		}
	}

	public String initAdd() {
		return super.initAdd();
	}

	@Override
	public String initEdit() {
		item = (Item) service.get(Item.class, item.getId());
		return super.initEdit();
	}

	@Override
	public String edit() {
		try {
			service.save(item);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
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

	public List<Item> getItemList() {
		return itemList;
	}

	@Override
	public String list() {
		setList();
		try {
			if (item == null) {
				item = new Item();
			}

			int maxRow = service.findTotalRow(item);
			maxPage = maxRow % NUM_OF_ROW_PER_PAGE == 0 ? maxRow / NUM_OF_ROW_PER_PAGE
					: maxRow / NUM_OF_ROW_PER_PAGE + 1;

			itemList = service.findByPaging(item, pageNo);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	@Override
	public void ajaxListByPage() {
		String status = list();
		if (SUCCESS.equals(status)) {
			writeToHtml(HtmlUtils.generateItemSearchResult(itemList));
		} else {
			writeToHtml("Error Found!");
		}

	}

}
