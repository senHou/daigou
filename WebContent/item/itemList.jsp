<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../header.jsp"/> 
<title>List Item</title>
<script>
$(document).ready(function(){
	$("#addItem").click(function(){
		redirect("initAddItem");
		return false;
	});
	
	$(".searchResultTable").on("change",".options",function(){
		if ($(this).val() != "") {
			var itemId = $(this).parent().parent().children(":first-child").text();
			var url = $(this).val() + "?item.id="+itemId;
			redirect(url);
		}
	});
});
</script>
	<div class = "center" id = "itemSearchDiv">
		<form action="listItem" action="post">
			<table class="searchTable">
				<tr>
					<td>Brand:</td>
					<td>
						<select class = "brandSelect" name="item.brand.id">
							<option value="">--Select--</option>
							<s:iterator value="brandList" id="list">
								<option value = '<s:property value="#list.id" />'> <s:property value="#list.name" /></option>
							</s:iterator>
						</select>
					</td>
				
					<td>Name:</td>
					<td><input type="text" name="item.name"  value='<s:property value="item.name" />'/></td>
					<td><input type="submit" value="Search"></td>
					<td><button id="addItem">Add Item</button></td>
				</tr>
			</table>
		</form>
	</div>
	<table class="searchResultTable" style="width:100%">
		<tr>
			<th style="width:30%">Item Id</th>
			<th style="width:30%">Item Brand</th>
			<th style="width:30%">Item Name</th>
			<th style="width:10%">Options</th>
		</tr>
		<s:iterator value="itemList" id="list" status="rowstatus">
			<s:if test="#rowstatus.odd == true">
				<tr class="removable odd">
			</s:if>
			<s:else>
				<tr class="removable even">
			</s:else>
					<td class = "odd"><s:property value="#list.id" /></td>
					<td class = "odd"><s:property value="#list.brand.name" /></td>
					<td class = "odd"><s:property value="#list.name" /></td>
					<td>
						<select style="width:100%"  class = "options" name="options">
							<option value="">Option</option>
							<option value="initItemEdit">Edit</option>
						</select>
					</td>
				</tr>
		</s:iterator>
	</table>
<jsp:include page="../pagination.jsp">
	<jsp:param value="Item" name="action"/>
</jsp:include>
<jsp:include page="../footer.jsp"/>
