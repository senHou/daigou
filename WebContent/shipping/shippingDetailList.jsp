<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../header.jsp"/> 
<title>display shipping details</title>
<script type="text/javascript">
$(document).ready(function() {
	$("#shippingDetailTable").on("change",".options",function(){
		if ($(this).val() != "") {
			var id = $(this).parent().parent().children(":first-child").text();
			var url = $(this).val() + "?detail.id="+id;
			redirect(url);
		}
	});
});
</script>
	<div class = "searchResultDiv">
		<table class="searchResultTable">
			<tr>
				<th style="width:10%" >Shipping No</th>
				<th style="width:8%">Date</th>
				<th style="width:8%">Customer Name</th>
				<th style="width:9%">Phone Number</th>
				<th>Address</th>
				<th style="width:8%">Total</th>
				<th style="width:8%">Agent</th>
				<th style="width:15%">Url</th>
			</tr>

			<tr>
				<td> <s:property value="shipping.shippingNo" /></td>
				<td> <s:property value="shipping.date" /></td>
				<td> <s:property value="shipping.customer.name" /></td>
				<td> <s:property value="shipping.phoneNumber" /></td>
				<td style="font-size:12px"> <s:property value="shipping.address" /></td>
				<td class="alignCenter"> <s:property value="shipping.cost" /></td>
				<td> <s:property value="shipping.agent" /></td>
				<td><a class="url" href="<s:property value="shipping.shippingCompany.url" />"><s:property value="shipping.shippingCompany.url" /></a></td>
			</tr>
		</table>	
	</div>
		
	<div class= "center shippingDetailDiv">
		<table id = "shippingDetailTable">
			<tr>
				<th style="width:10%">ID</th>
				<th style="width:10%">Shipping No</th>
				<th style="width:20%">Item</th>
				<th style="width:10%">Price</th>
				<th style="width:10%">Quantity</th>
				<th style="width:10%">Option</th>
			</tr>
			
			<s:iterator value="shippingDetailList" id="list">
				<tr>
					<td><s:property value="#list.id" /></td>
					<td><s:property value="#list.shippingNo" /></td>
					<td><s:property value="#list.item.brand.name" /> - <s:property value="#list.item.name" /></td>
					<td><s:property value="#list.soldPrice" /></td>
					<td><s:property value="#list.quantity" /></td>
					<td>
						<select  class = "options" name="options">
							<option value="">Option</option>
							<option value="initShippingDetailEdit">Edit</option>
							<option value="deleteShippingDetail">Delete</option>
						</select>
					</td>
				</tr>
			</s:iterator>
			
		</table>
	</div>
<jsp:include page="../footer.jsp"/>