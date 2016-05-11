package action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import utils.DataManager;

public abstract class CommonAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	protected HttpServletResponse response;
	protected HttpServletRequest request;
	protected DataManager dataManager;
	
	public CommonAction(){
		dataManager = DataManager.getInstance();
	}
	
	public String initAdd() {
		return SUCCESS;
	}

	public String initEdit() {
		return SUCCESS;
	}

	public abstract String add();

	public abstract String edit();

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
}
