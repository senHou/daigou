<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../header.jsp"/> 
<title>Display Brand</title>
<script>
$(document).ready(function(){
	$("#addBrand").click(function(){
		redirect("initAddBrand");
		return false;
	});
	
	$(".searchResultTable").on("change",".options",function(){
		if ($(this).val() != "") {
			var brandId = $(this).parent().parent().children(":first-child").text();
			var url = $(this).val() + "?brand.id="+brandId;
			redirect(url);
		}
	});
});
</script>
<div class = "center" id = "brandSearchDiv">
	<form id = "searchForm" class = "searchForm" method="post" action="listBrand">
			<input id="maxPage" type="hidden" name="maxPage" value="<s:property value= 'maxPage'/>" />
			<table class = "searchTable">
				<tr>
					<td>Brand Name:</td>
					<td><input id="brandName"  type="text" name="brand.name"  value="<s:property value="brand.name" />"/></td>
					<td><input type="submit" value="Search" /></td>
					<td><button id="addBrand">Add Brand</button></td>
				</tr>
			</table>
		</form>
</div>

<div class= "searchResultDiv center">
	<table class="searchResultTable center" style="width:100%">
		<tr id = "header" style="width:100%">
			<th style="width:45%" >Brand Id</th>
			<th style="width:45%">Brand Name</th>
			<th style="width:10%">Options</th>
		</tr>
		<s:iterator value="brandList" id="list" status="rowstatus">
			<s:if test="#rowstatus.odd == true">
				<tr class="removable odd">
					<td><s:property value="#list.id" /></td>
					<td><s:property value="#list.name" /></td>
					<td>
						<select style="width:100%"  class = "options" name="options">
							<option value="">Option</option>
							<option value="initBrandEdit">Edit</option>
						</select>
					</td>
				</tr>
			</s:if>
			<s:else>
				<tr class="removable even">
					<td><s:property value="#list.id" /></td>
					<td><s:property value="#list.name" /></td>
					<td>
						<select style="width:100%"  class = "options" name="options">
							<option value="">Option</option>
							<option value="initBrandEdit">Edit</option>
						</select>
					</td>
				</tr>
			</s:else>
			
		</s:iterator>
	</table>	
</div>	
<jsp:include page="../pagination.jsp">
	<jsp:param value="Brand" name="action"/>
</jsp:include>
<jsp:include page="../footer.jsp"/>