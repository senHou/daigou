package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import factory.DaoFactory;
import po.Item;
import service.ItemService;
import service.Service;
import utils.HtmlUtils;

public class ItemAction extends CommonAction{
	
	private Service service;
	private String brandId;

	
	public ItemAction() {
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
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	@Override
	public String add() {
		return null;
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
}
