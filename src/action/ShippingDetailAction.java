package action;

import java.util.ArrayList;
import java.util.List;

import po.Item;
import po.ShippingDetail;
import service.ItemService;
import service.ShippingDetailService;

public class ShippingDetailAction extends CommonAction {

	private ShippingDetailService service;
	private ShippingDetail detail;
	private List<Item> itemList;
	public ShippingDetailAction() {
		super();
		service = new ShippingDetailService();
		itemList = new ArrayList<Item>();
	}

	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String initEdit() {
		detail = (ShippingDetail) service.get(ShippingDetail.class, detail.getId());
		ItemService itemService = new ItemService();
		itemList = itemService.findByBrandId(String.valueOf(detail.getItem().getBrand().getId()));
		return super.initEdit();
	}

	@Override
	public String edit() {
		try {
			service.update(detail);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	@Override
	public String list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajaxListByPage() {
		// TODO Auto-generated method stub

	}

	public ShippingDetail getDetail() {
		return detail;
	}

	public void setDetail(ShippingDetail detail) {
		this.detail = detail;
	}
	
	public List<Item> getItemList() {
		return itemList;
	}
	
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	
}
