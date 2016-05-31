package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import interceptor.UserAware;
import po.Brand;
import po.User;
import service.Service;
import utils.DataManager;

public abstract class CommonAction extends ActionSupport
		implements ServletRequestAware, ServletResponseAware, UserAware, ModelDriven<User> {

	public final static String BRAND_LIST = "brandList";
	public final static String CUSTOMER_LIST = "customerList";
	public final static String SHIPPING_COMPANY_LIST = "shippingCompanyList";
	public final static int NUM_OF_ROW_PER_PAGE = 3;
	

	protected User user;

	protected HttpServletResponse response;
	protected HttpServletRequest request;
	protected DataManager dataManager;
	protected String errorMessage;
	protected int pageNo;
	
	private String dataManagerType;

	public CommonAction() {
		dataManager = DataManager.getInstance();
	}

	public String initAdd() {
		return SUCCESS;
	}

	public String initEdit() {
		return SUCCESS;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDataManagerType() {
		return dataManagerType;
	}

	public void setDataManagerType(String dataManagerType) {
		this.dataManagerType = dataManagerType;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public abstract String add();

	public abstract String edit();

	public abstract String list();
	public abstract List listByPaging();

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public void writeToHtml(String data) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updateDataManager() {
		Service service = new Service();
		if (dataManagerType.equals("ALL")) {
			dataManager.getDataMap().put(BRAND_LIST, service.getAll(Brand.class));
		}
	}

	// private void initService(){
	// String className = this.getClass().getName();
	//
	// String serviceClassName =
	// Service.class.getPackage().getName()+"."+className.substring(className.lastIndexOf(".")+1,className.lastIndexOf("Action"))+"Service"
	// ;
	// try {
	// service = (Service)Class.forName(serviceClassName).newInstance();
	// System.out.println(service.getClass().getName());
	// }catch(Exception e){
	// e.printStackTrace();
	// }
	//
	// }

	@Override
	public void setUser(User user) {
		this.user = user;
	}

	public User getUser(User user) {
		return this.user;
	}

	@Override
	public User getModel() {
		return this.user;
	}

	public static void main(String[] args) {
		CommonAction action = new ItemAction();
	}
}
