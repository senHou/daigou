package action;

import po.Shipping;
import po.ShippingCompany;
import service.ShippingCompanyService;

public class ShippingCompanyAction extends CommonAction{

	private ShippingCompany shippingCompany;
	
	public ShippingCompanyAction() {
		service = new ShippingCompanyService();
	}
	
	@Override
	public String edit() {
		service.save(shippingCompany);
		return SUCCESS;
	}
	
	@Override
	public String initEdit(){
		shippingCompany = (ShippingCompany)service.get(ShippingCompany.class, shippingCompany.getId());
		return super.initEdit();
	}

	@Override
	public String list() {
		setShippingCompanyList(((ShippingCompanyService)service).search(shippingCompany));
		return SUCCESS;
	}

	@Override
	public void ajaxListByPage() {
		
	}
	
	@Override
	public String add(){
		service.save(shippingCompany);
		return super.add();
	}

	public ShippingCompany getShippingCompany() {
		return shippingCompany;
	}

	public void setShippingCompany(ShippingCompany shippingCompany) {
		this.shippingCompany = shippingCompany;
	}
}
