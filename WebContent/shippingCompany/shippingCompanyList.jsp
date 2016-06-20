<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../header.jsp"/> 
<title>display shipping details</title>
<script type="text/javascript">
$(document).ready(function() {
	$(".options").change(function(){
		if ($(this).val() != "") {
			var id = $(this).parent().parent().children(":first-child").text();
			var url = $(this).val() + "?shippingCompany.id="+id;
			redirect(url);
		}
	});
	
	$("#addShippingCompanyButton").click(function(){
		redirect("initAddShippingCompany");
		return false;
	});
});
</script>

<div class="center">	
	<div class = "center" id="shippingCompanySearchDiv">
		<form id="shippingCompanySearchFomr" method="post" action="listShippingCompany">
			<table class="center">
				<tr>
					<td>name:</td>
					<td><input type="text" name = "shippingCompany.name" /></td>
					<td><input type="submit" value="Search" /></td>
					<td><button id="addShippingCompanyButton" >Add</button></td>
				</tr>
			</table>
		</form>
	</div>

	<div class="center" id="shippingCompanyListDiv">
		<table class="center"> 
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Url</th>
				<th>Options</th>
			</tr>
			<s:iterator value="shippingCompanyList" id="list">
				<tr>
					<td><s:property value="#list.id" /></td>
					<td><s:property value="#list.name" /></td>
					<td><s:property value="#list.url" /></td>
					<td>
						<select class="options" >
							<option value="">-- Select --</option>
							<option value="initShippingCompanyEdit">Edit</option>
						</select>
					</td>
				</tr>
			</s:iterator>
		</table>
	</div>
</div>

<jsp:include page="../footer.jsp"/>