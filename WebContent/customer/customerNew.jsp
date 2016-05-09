<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery-1.12.3.js"></script>
<script>
$(document).ready(function(){
	$("#uploadCustomerButton").click(function(){
		location.href = "initUploadCustomerFile";
		return false;
	});	
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Customer</title>
</head>
<body>
	<div class="contanier">
		
		<jsp:include page="../header.jsp"/> 
		<div class = "content">
			<form id="" method="post" action="addCustomer">
				<table id="addBrandTable">
					<tr>
						<td>Customer Id:</td>
						<td><input type="text" value='<s:property value="id"/>' name="customer.id" /></td>
					</tr>
					<tr>
						<td>Customer Name:</td>
						<td><input type="text" value='<s:property value="name"/>' name="customer.name" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Add" /></td>
						<td><button id="uploadCustomerButton">upload</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>