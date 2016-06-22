package utils;

import java.util.List;

import po.Brand;
import po.Customer;
import po.Shipping;

public class HtmlUtils {
	public static String genreateOption(String name, String value) {
		return "<option value=\"" + value + "\">" + name + "</option>";
	}

	public static String generateShippingSearchResult(List<Shipping> shippingList) {
		StringBuffer html = new StringBuffer();
		int count = 1;
		for (Shipping shipping : shippingList) {
			if (count % 2 != 0){
				html.append("<tr class = 'removable odd'>");
			}else {
				html.append("<tr class = 'removable even'>");
			}
			html.append("<td>");
			html.append(shipping.getShippingNo());
			html.append("</td>");
			html.append("<td>");
			html.append(DateUtils.parseDateToString(shipping.getDate(), "dd/MM/yyyy"));
			html.append("</td>");
			html.append("<td>");
			html.append(shipping.getCustomer().getName());
			html.append("</td>");
			html.append("<td>");
			html.append(shipping.getPhoneNumber());
			html.append("</td>");
			html.append("<td style='font-size:12px'>");
			html.append(shipping.getAddress());
			html.append("</td>");
			html.append("<td>");
			html.append(shipping.getCost());
			html.append("</td>");
			html.append("<td>");
			html.append(shipping.getAgent());
			html.append("</td>");
			html.append("<td>");
			html.append(shipping.getShippingCompany().getUrl());
			html.append("</td>");
			html.append("<td>");
			html.append("<select style='width:100%'  class = 'options' name='options'>");
			html.append("<option value=''>Option</option>");
			html.append("<option value='listShippingDetail'>Detail</option>");
			html.append("<option value='initShippingEdit'>Edit</option>");
			html.append("</select>");
			html.append("</td>");
			html.append("</tr>");
		}
		return html.toString();
	}

	public static String generateCustomerSearchResult(List<Customer> customerList) {
		StringBuffer html = new StringBuffer();
		int count = 1;
		for (Customer customer : customerList) {
			if (count % 2 != 0){
				html.append("<tr class = 'removable odd'>");
			}else {
				html.append("<tr class = 'removable even'>");
			}
			html.append("<td>");
			html.append(customer.getId());
			html.append("</td>");
			html.append("<td>");
			html.append(customer.getName());
			html.append("</td>");
			html.append("<td>");
			html.append("<select style='width:100%'  class = 'options' name='options'>");
			html.append("<option value=''>Option</option>");
			html.append("<option value='initCustomerEdit'>Edit</option>");
			html.append("</select>");
			html.append("</td>");
			html.append("</tr>");
			count ++;
		}
		return html.toString();
	}
	
	public static String generateBrandSearchResult(List<Brand> brandList) {
		StringBuffer html = new StringBuffer();
		int count = 1;
		for (Brand brand : brandList) {
			if (count % 2 != 0){
				html.append("<tr class = 'removable odd'>");
			}else {
				html.append("<tr class = 'removable even'>");
			}
			html.append("<td>");
			html.append(brand.getId());
			html.append("</td>");
			html.append("<td>");
			html.append(brand.getName());
			html.append("</td>");
			html.append("<td>");
			html.append("<select style='width:100%'  class = 'options' name='options'>");
			html.append("<option value=''>Option</option>");
			html.append("<option value='initBrandEdit'>Edit</option>");
			html.append("</select>");
			html.append("</td>");
			html.append("</tr>");
			count ++;
		}
		return html.toString();
	}
}
