<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../header.jsp"/> 
<title>Add Customer</title>
<script>
$(document).ready(function(){
	$("#uploadCustomerButton").click(function(){
		location.href = "initUploadCustomerFile";
		return false;
	});	
});
</script>
<form id="" method="post" action="addCustomer">
	<table id="addBrandTable" class="addTalbe">
		<tr>
			<td class="title">Customer Id:</td>
			<td><input type="text" value='<s:property value="id"/>' name="customer.id" /></td>
		</tr>
		<tr>
			<td class="title">Customer Name:</td>
			<td><input type="text" value='<s:property value="name"/>' name="customer.name" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Add" /></td>
			<td><button id="uploadCustomerButton">upload</button></td>
		</tr>
	</table>
</form>
<jsp:include page="../footer.jsp"/>
