<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../header.jsp"/> 
<title>display shipping details</title>
<script type="text/javascript">
$(document).ready(function() {
	$("#editTable").on("change",".brandSelect",function(){
		var brandId = $(this).val();
		var obj = $(this).parent().parent();
		if (brandId != "") {
			$.ajax({
				url: "printItemOptions", 
				type:"post",
				contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				data:{"brandId": brandId},
				dataType:"text",
				success: function(result){
					$("#itemSelect").html("");
					$("#itemSelect").append("<option value=''>--Select--</option>"+result);
				}
			});
		}
	});
});
</script>
	<div class ="editDiv">
		<form id = "editForm" class = "editForm" method="post" action ="shippingDetailEdit">
			<table class = "editTable" id = "editTable"> 
				<tr>
					<td class="title">Shipping Detail Id:</td>
					<td><input type="text" name="detail.id" value="<s:property value="detail.id" />"  readonly="readonly"/></td>
				</tr>
				<tr>
					<td class="title">Shipping No:</td>
					<td><input type="text" name="detail.shippingNo" value="<s:property value="detail.shippingNo" />" readonly="readonly" /></td>
				</tr>
				<tr>
					<td class="title">Price:</td>
					<td><input type="text" name="detail.soldPrice" value="<s:property value="detail.soldPrice" />" /></td>
				</tr>
				<tr>
					<td class="title">Brand:</td>
					<td>
						<select name="detail.item.brand.id" class = "brandSelect">
							<s:iterator value="brandList" id="list">
								<s:if test="%{detail.item.brand.id == #list.id}">
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
					<td class="title">Item:</td>
					<td>
						<select name="detail.item.id" class = "itemSelect" id="itemSelect">
							<option value="">-- Select --</option>
							<s:iterator value="itemList" id="list">
								<s:if test="%{detail.item.id == #list.id}">
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
					<td class="title">Quantity:</td>
					<td><input type="text" name="detail.quantity" value="<s:property value="detail.quantity" />" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="update" /></td>
				</tr>
			</table>
		</form>
	</div>

<jsp:include page="../footer.jsp"/>