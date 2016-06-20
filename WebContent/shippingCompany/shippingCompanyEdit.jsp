<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../header.jsp"/> 
<title>edit shipping company</title>
<script type="text/javascript">
</script>

<div class="center">
	<form id="shippingCompanyEditForm" method="post" action="editShippingCompany">
		<table class="center"> 
			<tr>
				<td class="title">Id:</td>
				<td><input type="text" name = "shippingCompany.id" value="<s:property value = "shippingCompany.id"/>" readonly="readonly" /></td>
			</tr>
			<tr>
				<td class="title">Name:</td>
				<td><input type="text" name = "shippingCompany.name" value="<s:property value = "shippingCompany.name"/>" /></td>
			</tr>
			<tr>
				<td class="title">Url:</td>
				<td><input type="text" name = "shippingCompany.url" value="<s:property value = "shippingCompany.url"/>" /></td>
			</tr>
			<tr> 
				<td colspan="2" align="right"><input type="submit" value="Update"/></td>
			</tr>
		</table>
	</form>
</div>

<jsp:include page="../footer.jsp"/>