<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../header.jsp"/> 
<title>Edit Customer</title>
<script>
$(document).ready(function(){
	
});
</script>
 <div class ="editDiv">
	<form id = "editForm" class = "editForm" method="post" action ="editCustomer">
		<input type="hidden" name="originCustomerId"  value="<s:property value="customer.id" />" />
		<table class = "editTable"> 
			<tr>
				<td>customer Id:</td>
				<td><input type="text" name="customer.id" value="<s:property value="customer.id" />" /></td>
			</tr>
			
			<tr>
				<td>Customer Name:</td>
				<td><input type="text"  name="customer.name" value="<s:property value="customer.name" />" /></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="update" /></td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="../footer.jsp"/>