package test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dao.hibernate.CustomerDao;
import dao.hibernate.HibernateDao;
import dao.hibernate.ItemDao;
import po.Brand;
import po.Customer;
import po.Item;
import po.Shipping;
import po.ShippingCompany;
import po.ShippingDetail;
import service.Service;
import service.ShippingDetailService;
import service.ShippingService;

public class Testing {

	public static void main(String[] args) {

//		WeekOrderDetailAction action = new WeekOrderDetailAction();
//		
//		List<WeekOrderDetail> orderDetailList = new ArrayList<WeekOrderDetail>();
//		Date date = new Date();
//		WeekOrderDetail orderDetail = new WeekOrderDetail(2, "鎶よ倽鐗�", 1, "swisse", DateUtils.getWeekNo(date), DateUtils.getYear(date), 3, date);
//		orderDetailList.add(orderDetail);
//		action.setOrderDetailList(orderDetailList);
//		action.save();
		
//		File file = new File("D:\\australiaBuyExcel\\weekorderdetail.xlsx");
//		
//		ExcelUpload excel = new WeekOrderDetailExcelUpload(file);
		try {
//			List<Object> objectList = excel.upload(0, 0);
//			for (Object object : objectList) {
//				System.out.println(object);
//			}
//			
//			List<Map<String, String>> rowMapList = excel.getRowValueList();
//			for (Map<String, String> map : rowMapList) {
//				System.out.println(map.get("errorMessage"));
//			}
			
//			BrandAction action = new BrandAction();
//			action.setFileName("/Users/sen/Desktop/brand.xls");
//			action.uploadFile();
			
			//updateShippingDetail();
			//testShipping();
			//testItem();
			
			//testCustomer();
			testItem();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateShippingDetail(){
		Service service = new ShippingDetailService();
		ShippingDetail detail = new ShippingDetail("77000456978", new Item(3,new Brand(1,"swisse"),"月见草"),130, 3);
		detail.setId(8);
		service.update(detail);
	}
	
	public static void testShipping(){
		Service service = new ShippingService();
		
		Shipping shipping = new Shipping();
		Customer customer = new Customer("410105198711030135","侯森");
		Set<ShippingDetail> shippingDetailSet = new HashSet<ShippingDetail>();
		shippingDetailSet.add(new ShippingDetail("77000456978", new Item(1,new Brand(1,"swisse"),"蔓越莓"),120, 2));
		shipping.setAddress("50 campise street");
		shipping.setDate(new Date());
		shipping.setCustomer(customer);
		shipping.setShippingNo("77000456978");
		shipping.setShippingCompany(new ShippingCompany(1,"中邮","www.cnpex.com.au"));
		shipping.setShippingDetailSet(shippingDetailSet);
		shipping.setPhoneNumber("13544448888");
		double cost = 0;
		for (ShippingDetail shippingDetail : shippingDetailSet) {
			cost += shippingDetail.getSoldPrice() * shippingDetail.getQuantity();
		}
		shipping.setCost(cost);
		service.save(shipping);
		
//		Shipping shipping = (Shipping) service.get(Shipping.class, "77000456978");
//		System.out.println(shipping);
	}
	
	
	public static void testItem(){
		HibernateDao dao = new ItemDao();
		List<Item> itemList = dao.findAllOrderBy(Item.class, "id", "asc");
		for (Item item : itemList) {
			System.out.println(item.getId());
		}
	}
	
	public static void testCustomer() {
		CustomerDao dao = new CustomerDao();
		List<Customer> customerList = dao.findAllOrderBy(Customer.class, "id", "asc");
		for (Customer customer : customerList) {
			System.out.println(customer.getId());
		}
	}
}
