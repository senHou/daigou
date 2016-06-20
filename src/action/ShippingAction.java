package action;

import java.util.List;

import factory.DaoFactory;
import po.Brand;
import po.Customer;
import po.Shipping;
import po.ShippingCompany;
import po.ShippingDetail;
import service.Service;
import service.ShippingService;
import utils.DateUtils;
import utils.HtmlUtils;
import utils.StringUtil;

public class ShippingAction extends CommonAction {

	private ShippingService service;
	private List shippingList;
	private List shippingDetailList;
	private Shipping shipping;
	private String customerName;
	private String originShippingNo;
	
	
	private List<ShippingDetail> detailList;

	public ShippingAction() {
		super();
		service = new ShippingService();
	}

	public String add() {
		try {
			double totalCost = 0;
			for (ShippingDetail detail : detailList) {
				totalCost += detail.getSoldPrice() * detail.getQuantity();
			}

			shipping.setCost(totalCost);
			shipping.getShippingDetailSet().addAll(detailList);
			service.save(shipping);
			errorMessage = null;
		} catch (Exception e) {
			errorMessage = "Add shipping error.";
			setList();
			e.printStackTrace();
			return ERROR;
		}
		
		return SUCCESS;
	}

	public String display() {
		shippingList = service.getAll(Shipping.class);
		return SUCCESS;
	}
	
	public String initEdit(){
		shipping = (Shipping)service.get(Shipping.class, shipping.getShippingNo().trim());
		return super.initEdit();
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}


	public List getShippingList() {
		return shippingList;
	}

	public void setShippingList(List shippingList) {
		this.shippingList = shippingList;
	}
	
	public String getOriginShippingNo() {
		return originShippingNo;
	}
	
	public void setOriginShippingNo(String originShippingNo) {
		this.originShippingNo = originShippingNo;
	}



	public List<ShippingDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<ShippingDetail> detailList) {
		this.detailList = detailList;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public List getShippingDetailList() {
		return shippingDetailList;
	}
	
	public void setShippingDetailList(List shippingDetailList) {
		this.shippingDetailList = shippingDetailList;
	}

	@Override
	public String list() {
		try {
			if (shipping == null) {
				shipping = new Shipping();
			}

			int maxRow = service.findTotalRow(shipping);
			maxPage = maxRow % NUM_OF_ROW_PER_PAGE == 0 ? maxRow / NUM_OF_ROW_PER_PAGE
					: maxRow / NUM_OF_ROW_PER_PAGE + 1;

			shippingList = service.findByPaging(shipping, pageNo);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	@Override
	public String edit(){
		try {
			service.update(shipping, !shipping.getShippingNo().equalsIgnoreCase(originShippingNo), originShippingNo);
			return SUCCESS;
		}catch(Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	@Override
	public void ajaxListByPage() {
		try {

			if (shipping == null) {
				shipping = new Shipping();
			}
			int maxRow = service.findTotalRow(shipping);

			maxPage = maxRow % NUM_OF_ROW_PER_PAGE == 0 ? maxRow / NUM_OF_ROW_PER_PAGE
					: maxRow / NUM_OF_ROW_PER_PAGE + 1;

			shippingList = service.findByPaging(shipping, pageNo);

			writeToHtml(HtmlUtils.generateShippingSearchResult(shippingList));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String listDetail(){
		shipping = (Shipping)service.get(Shipping.class, shipping.getShippingNo().trim());
		shippingDetailList = ((ShippingService) service).findShippingDetailByShippingNo(shipping.getShippingNo());
		return SUCCESS;
	}
}
