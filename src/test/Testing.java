package test;

import action.BrandAction;

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
			
			BrandAction action = new BrandAction();
			action.setFileName("/Users/sen/Desktop/brand.xls");
			action.uploadFile();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
