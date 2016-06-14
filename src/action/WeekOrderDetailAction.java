package action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import factory.DaoFactory;
import po.Brand;
import po.Item;
import po.WeekOrderDetail;
import service.Service;
import service.WeekOrderDetailService;

public class WeekOrderDetailAction extends CommonAction {

	private List<WeekOrderDetail> orderDetailList;
	private List<Brand> brandList;
	private static Map<Integer, List<Item>> itemMap;
	private Service service;
	
	public WeekOrderDetailAction(){
		super();
		service = new WeekOrderDetailService();
	}

	public String saveWeekOrderDetail() {
		return SUCCESS;
	}

	public List<WeekOrderDetail> getOrderDetailList() {
		return orderDetailList;
	}
	
	public void setOrderDetailList(List<WeekOrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	public List<Brand> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<Brand> brandList) {
		this.brandList = brandList;
	}

	public static Map<Integer, List<Item>> getItemMap() {
		return itemMap;
	}

	public static void setItemMap(Map<Integer, List<Item>> itemMap) {
		WeekOrderDetailAction.itemMap = itemMap;
	}

	@Override
	public String add() {
		brandList = (List<Brand>)service.getAll(Brand.class);
		return SUCCESS;
	}

	@Override
	public String edit() {
		// TODO Auto-generated method stub
		return null;
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
}
