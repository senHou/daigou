<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../header.jsp"/> 
<title>display shipping details</title>
<script type="text/javascript">
$(document).ready(function() {
	
});
</script>
	<div class ="editDiv">
		<form id = "editForm" class = "editForm" method="post" action ="editShippingDetail">
			<table class = "editTable"> 
				<tr>
					<td>Shipping Detail Id:</td>
					<td><input type="text" name="detail.id" value="<s:property value="detail.id" />" /></td>
				</tr>
				<tr>
					<td>Shipping No:</td>
					<td><input type="text" name="detail.shippingNo" value="<s:property value="detail.shippingNo" />" /></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="submit" value="update" /></td>
				</tr>
			</table>
		</form>
	</div>

<jsp:include page="../footer.jsp"/>