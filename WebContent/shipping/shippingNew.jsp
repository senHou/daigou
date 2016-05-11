<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery-1.12.3.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add shipping</title>
<script type="text/javascript">

$(document).ready(function(){
	$("#brandSelect").change(function(){
		var brandId = $("#brandSelect").val();
		if (brandId != "") {
			$.ajax({
				url: "printItemOptions", 
				type:"post",
				contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				data:{"brandId": brandId},
				dataType:"text",
				success: function(result){
					$("#itemSelect").html("");
					
					$("#itemSelect").append("<option value=''>--select--</option>"+result);
				}
			});
		}
	});
});

function addNewCustomer(){
	location.href = "initAddCustomer";
	return false;
}
</script>
</head>
<body>
	<div class="contanier">
		<jsp:include page="../header.jsp"/> 
		<div class = "content">
			<form name="addShipping" action="addShipping" method="post">
				<table id="addShippingTable" cellspacing="0">
					<s:if test="%{errorMessage != null}">
						<tr>
							<td colspan="2" class = "error">
								<s:property value="errorMessage" />
							</td>
						</tr>
					</s:if>
					<tr>
						<td class="title">Shipping No：</td>
						<td><input type="text" name="shipping.shippingNo" /></td>
					</tr>
					<tr>
						<td class="title">receiver：</td>
						<td>
							<select name="customer.id">
								<option value="">--Select--</option>
								<s:iterator value="customerList" id="list">
									<option value = '<s:property value="#list.id" />'> <s:property value="#list.name" />-<s:property value="#list.id" /></option>
								</s:iterator>
							</select>
							<button name="addNewCustomerButton" onclick="return addNewCustomer();" >Add New</button>
						</td>
					</tr>
					<tr>
						<td class="title">Mobile：</td>
						<td><input type="text" name="shipping.phoneNumber" /></td>
					</tr>
					
					<tr>
						<td class="title">Shipping Company:</td>
						<td><select name="shippingCompany.id" >
								<option value="">--Select--</option>
								<s:iterator value="shippingCompanyList" id="list">
									<option value = '<s:property value="#list.id" />'> <s:property value="#list.name" /></option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<td class="title">Post Address：</td>
						<td><input type="text" name="shipping.address" size = "40" /></td>
					</tr>
					
				</table>
				
				<table id = "shippingDetailTable">
					<tr>
						<th id = "shippingDetailSet_shippingNo">Shipping No.</th>
						<th>Brand</th>
						<th id = "shippingDetailSet_item">Item</th>
						<th id = "shippingDetailSet_soldPrice">Sold Price</th>
						<th id = "shippingDetailSet_quantity">Quantity</th>
					</tr>
					<tr id = "undeletebleTr" class="undeleteble">
						<td><input type="text" name="shippingDetailSet[0].shippingNo"/></td>
						<td>
							<select id = "brandSelect">
								<option value="">--Select--</option>
								<s:iterator value="brandList" id="list">
									<option value = '<s:property value="#list.id" />'> <s:property value="#list.name" /></option>
								</s:iterator>
							</select>
						</td>
						<td>
							<select id="itemSelect" name="shippingDetailSet[0].item">
								<option value="">--Select--</option>
							</select>
						</td>
						<td><input type="text" name="shippingDetailSet[0].soldPrice"/></td>
						<td><input type="text" name="shippingDetailSet[0].quantity"/></td>
					</tr>
					<tr>
						<td colspan="4" align="center">
							<input type="submit" name="add" value="Add" />
						</td>
					</tr>
				</table>
				
			</form>
		</div>
	</div>
</body>
</html>