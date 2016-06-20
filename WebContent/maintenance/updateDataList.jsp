<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../header.jsp"/> 
<title>Update Data List</title>
<script type="text/javascript">
$(document).ready(function() {
	$("#updateButton").click(function(){
		
		var url = "setList";
		var data = $("#updateDataListForm").serialize();
		data = decodeURIComponent(data, true ); 
		$.ajax({
			url: url, 
			type:"post",
			data:data,
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			dataType:"text",
			success: function(result){
				alert("Success!");
			}
		});
		
		return false;
	});
});
</script>
<div class = "center">
	<form id = "updateDataListForm" method="post" action="setList">
		<table class="center">
			<tr>
				<td class="title">Update:</td>
				<td>
					<select id="updateDataListSelect" name = "updateType">
						<option value="ALL">-- *All --</option>
						<option value="brandList">Brand List</option>
						<option value="customerList">Customer List</option>
						<option value="shippingCompanyList">Shipping Company List</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input id="updateButton" type="button" value="Update" />
				</td>
			</tr>
		</table>
	</form>
</div>

<jsp:include page="../footer.jsp"/>