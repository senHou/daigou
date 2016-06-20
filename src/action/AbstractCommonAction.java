package action;

import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractCommonAction extends ActionSupport{
	public abstract String add();

	public abstract String edit();

	public abstract String list();

	public abstract void ajaxListByPage();
}
