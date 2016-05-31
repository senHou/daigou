package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import po.User;

public class LoginAction extends ActionSupport implements SessionAware, ModelDriven<User>{

	private User user = new User();
	private Map<String, Object> sessionAttributes = null;
	
	public String execute(){
		System.out.println("inside execute");
		if("shou".equals(user.getUsername()) && "shou123".equals(user.getPassword())){
			user.setName("sen hou");
			sessionAttributes.put("USER", user);
			return SUCCESS;
		}
		return INPUT;
	}
	
	@Override
	public User getModel() {
		return user;
	}

	@Override
	public void setSession(Map<String, Object> sessionAttributes) {
		// TODO Auto-generated method stub
		this.sessionAttributes = sessionAttributes;
		
	}

	
	public String logOut() {
		sessionAttributes.remove("USER");
		return SUCCESS;
	}
}
