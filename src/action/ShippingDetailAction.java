package action;

import po.ShippingDetail;
import service.ShippingDetailService;

public class ShippingDetailAction extends CommonAction {

	private ShippingDetailService service;
	private ShippingDetail detail;

	public ShippingDetailAction() {
		super();
		service = new ShippingDetailService();
	}

	@Override
	public String add() {
		// TODO Auto-generated method stub
		return null;
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
}
