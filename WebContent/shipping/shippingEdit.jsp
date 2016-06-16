<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../header.jsp"/> 
<title>display shipping details</title>
<script type="text/javascript">
$(document).ready(function() {
	
});
</script>
	<div class ="editDiv">
		<form id = "editForm" class = "editForm" method="post" action ="editShipping">
			<input type="hidden" name="originShippingNo"  value="<s:property value="shipping.shippingNo" />" />
			<input type="hidden" name="shipping.customer.id"  value="<s:property value="shipping.customer.id" />" />
			<table class = "editTable"> 
				<tr>
					<td>Shipping No:</td>
					<td><input type="text" name="shipping.shippingNo" value="<s:property value="shipping.shippingNo" />" /></td>
				</tr>
				<tr>
					<td>Date:</td>
					<td><input type="text"  id="datepicker" name="shipping.date" value="<s:property value="shipping.date" />" /></td>
				</tr>
				<tr>
					<td>Customer Name:</td>
					<td><input type="text"  name="shipping.customer.name" value="<s:property value="shipping.customer.name" />" /></td>
				</tr>
				<tr>
					<td>Phone Number:</td>
					<td><input type="text"  name="shipping.phoneNumber" value="<s:property value="shipping.phoneNumber" />" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><input type="text"  name="shipping.address" value="<s:property value="shipping.address" />" /></td>
				</tr>
				<tr>
					<td>Total Price:</td>
					<td><input type="text"  name="shipping.cost" readonly="readonly" value="<s:property value="shipping.cost" />" /></td>
				</tr>
				<tr>
					<td>Agent:</td>
					<td><input type="text"  name="shipping.agent" value="<s:property value="shipping.agent" />" /></td>
				</tr>
				<tr>
					<td class="title">Shipping Company:</td>
					<td><select name="shipping.shippingCompany.id" >
						<option value="">--Select--</option>
						<s:iterator value="shippingCompanyList" id="list">
							<s:if test="%{shipping.shippingCompany.id == #list.id}">
								<option value = '<s:property value="#list.id" />' selected="selected" > <s:property value="#list.name" /></option>
							</s:if>
							<s:else>
								<option value = '<s:property value="#list.id" />'> <s:property value="#list.name" /></option>
							</s:else>
						</s:iterator>
					</select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="update" /></td>
				</tr>
			</table>
		</form>
	</div>

<jsp:include page="../footer.jsp"/>