package action;

import com.opensymphony.xwork2.ActionSupport;

public abstract class CommonAction extends ActionSupport{
	
	public String initAdd(){
		return SUCCESS;
	}
	
	public String initEdit(){
		return SUCCESS;
	}
	
	public abstract String add();
	public abstract String edit();
}
