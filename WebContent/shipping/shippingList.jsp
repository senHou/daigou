<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../header.jsp"/> 
<title>display shipping</title>
<script type="text/javascript">
$(document).ready(function() {
	$(".url").click(function(){
		window.open("http://"+$(this).attr("href"));
		return false;
	});
	
	$("#addShipping").click(function(){
		redirect("initAddShipping");
		return false;
	});
	
	$(".searchResultTable").on("change",".options",function(){
		if ($(this).val() != "") {
			var shippingNo = $(this).parent().parent().children(":first-child").text();
			var url = $(this).val() + "?shipping.shippingNo="+shippingNo;
			redirect(url);
		}
	});
});
</script>
	<div class ="searchDiv">
		<form id = "searchForm" class = "searchForm" method="post" action="listShipping">
			<input id="maxPage" type="hidden" name="maxPage" value="<s:property value= 'maxPage'/>" />
			<table class = "searchTable">
				<tr>
					<td>Shipping No:</td>
					<td><input type="text" name="shipping.shippingNo" value="<s:property value="shipping.shippingNo" />"/></td>
					<td>Date:</td>
					<td><input type="text" id="datepicker" name="shipping.date" value="<s:property value="shipping.date" />" /></td>
					<td>Customer Name:</td>
					<td><input id="customerName"  type="text" name="shipping.customer.name"  value="<s:property value="shipping.customer.name" />"/></td>
					<td><input type="submit" value="Search" /></td>
					<td><button id="addShipping">Add New</button></td>
				</tr>
			</table>
		</form>
	</div>
	<div class= "searchResultDiv">
		<table class="searchResultTable">
			<tr id = "header">
				<th style="width:10%" >Shipping No</th>
				<th style="width:8%">Date</th>
				<th style="width:8%">Customer Name</th>
				<th style="width:9%">Phone Number</th>
				<th>Address</th>
				<th style="width:8%">Total</th>
				<th style="width:8%">Agent</th>
				<th style="width:15%">Url</th>
				<th style="width:8%">Options</th>
			</tr>
			<s:iterator value="shippingList" id="list" status="rowstatus">
				<s:if test="#rowstatus.odd == true">
				<tr class="removable odd">
				</s:if >
				<s:else>
				<tr class="removable even">
				</s:else>
					<td><s:property value="#list.shippingNo" /></td>
					<td><s:property value="#list.date" /></td>
					<td><s:property value="#list.customer.name" /></td>
					<td><s:property value="#list.phoneNumber" /></td>
					<td style="font-size:12px"> <s:property value="#list.address" /></td>
					<td class="alignCenter"> <s:property value="#list.cost" /></td>
					<td><s:property value="#list.agent" /></td>
					<td><a class="url" href="<s:property value="#list.shippingCompany.url" />"><s:property value="#list.shippingCompany.url" /></a></td>
					<td>
						<select style="width:100%"  class = "options" name="options">
							<option value="">Option</option>
							<option value="listShippingDetail">Detail</option>
							<option value="initShippingEdit">Edit</option>
						</select>
					</td>
				</tr>
			</s:iterator>
		</table>	
	</div>		

	<jsp:include page="../pagination.jsp">
		<jsp:param value="Shipping" name="action"/>
	</jsp:include> 		

<jsp:include page="../footer.jsp"/>