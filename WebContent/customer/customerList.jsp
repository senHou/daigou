<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../header.jsp"/> 
<title>Display Customer</title>
<script>
$(document).ready(function(){
	$("#addCustomer").click(function(){
		redirect("initAddCustomer");
		return false;
	});
	
	$(".searchResultTable").on("change",".options",function(){
		if ($(this).val() != "") {
			var customerId = $(this).parent().parent().children(":first-child").text();
			var url = $(this).val() + "?customer.id="+customerId;
			redirect(url);
		}
	});
});
</script>
<div class = "center" id = "customerSearchDiv">
	<form id = "searchForm" class = "searchForm" method="post" action="listCustomer">
			<input id="maxPage" type="hidden" name="maxPage" value="<s:property value= 'maxPage'/>" />
			<table class = "searchTable">
				<tr>
					<td>Customer Id:</td>
					<td><input type="text" name="customer.id" value="<s:property value="customer.id" />"/></td>
					<td>Customer Name:</td>
					<td><input id="customerName"  type="text" name="customer.name"  value="<s:property value="customer.name" />"/></td>
					<td><input type="submit" value="Search" /></td>
					<td><button id="addCustomer">Add Customer</button></td>
				</tr>
			</table>
		</form>
</div>

<div class= "searchResultDiv center">
	<table class="searchResultTable center" style="width:100%">
		<tr id = "header" style="width:100%">
			<th style="width:45%" >Customer Id</th>
			<th style="width:45%">Customer Name</th>
			<th style="width:10%">Options</th>
		</tr>
		<s:iterator value="customerList" id="list" status="rowstatus">
			<s:if test="#rowstatus.odd == true">
				<tr class="removable odd">
					<td><s:property value="#list.id" /></td>
					<td><s:property value="#list.name" /></td>
					<td>
						<select style="width:100%"  class = "options" name="options">
							<option value="">Option</option>
							<option value="initCustomerEdit">Edit</option>
						</select>
					</td>
				</tr>
			</s:if>
			<s:else>
				<tr class="removable even">
					<td><s:property value="#list.id" /></td>
					<td><s:property value="#list.name" /></td>
					<td>
						<select style="width:100%"  class = "options" name="options">
							<option value="">Option</option>
							<option value="initCustomerEdit">Edit</option>
						</select>
					</td>
				</tr>
			</s:else>
			
		</s:iterator>
	</table>	
</div>		
<jsp:include page="../pagination.jsp">
		<jsp:param value="Customer" name="action"/>
	</jsp:include>
<jsp:include page="../footer.jsp"/>