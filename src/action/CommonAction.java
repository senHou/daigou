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
import po.Customer;
import po.ShippingCompany;
import po.User;
import service.Service;
import utils.DataManager;

public abstract class CommonAction extends AbstractCommonAction
		implements ServletRequestAware, ServletResponseAware, UserAware, ModelDriven<User> {

	public final static String BRAND_LIST = "brandList";
	public final static String CUSTOMER_LIST = "customerList";
	public final static String SHIPPING_COMPANY_LIST = "shippingCompanyList";
	public final static int NUM_OF_ROW_PER_PAGE = 15;

	protected User user;

	protected HttpServletResponse response;
	protected HttpServletRequest request;
	protected static DataManager dataManager;
	protected String errorMessage;
	protected int pageNo = 1;
	protected int maxPage;

	protected List shippingCompanyList;
	protected List customerList;
	protected List brandList;
	protected Service service;

	private String dataManagerType;

	static {
		updateDataManager();
	}

	public CommonAction() {
		
	}

	public String initAdd() {
		setList();
		return SUCCESS;
	}

	public String initEdit() {
		setList();
		return SUCCESS;
	}

	protected void setList() {
		setBrandList(dataManager.getDataMap().get(BRAND_LIST));
		setCustomerList(dataManager.getDataMap().get(CUSTOMER_LIST));
		setShippingCompanyList(dataManager.getDataMap().get(SHIPPING_COMPANY_LIST));
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

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

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
			System.out.println(data);
			response.getWriter().write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void updateDataManager() {
		Service service = new Service();
		dataManager = DataManager.getInstance();
		dataManager.getDataMap().put(BRAND_LIST, service.getAll(Brand.class));
		dataManager.getDataMap().put(SHIPPING_COMPANY_LIST, service.getAll(ShippingCompany.class));
		dataManager.getDataMap().put(CUSTOMER_LIST, service.getAll(Customer.class));
	}


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

	public List getBrandList() {
		return brandList;
	}

	public void setBrandList(List brandList) {
		this.brandList = brandList;
	}

	public List getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List customerList) {
		this.customerList = customerList;
	}

	public void setShippingCompanyList(List shippingCompanyList) {
		this.shippingCompanyList = shippingCompanyList;
	}

	public List getShippingCompanyList() {
		return shippingCompanyList;
	}

	@Override
	public String add() {
		setList();
		return SUCCESS;
	}
}
