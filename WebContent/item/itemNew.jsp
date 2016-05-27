<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../header.jsp"/> 
<title>Add Item</title>
<form id="brandId" method="post" action="addItem">
	<table id="addItemTable" class="addTalbe">
		<tr>
			<td class="title">Item Brand:</td>
			<td>
				<select class = "brandSelect" name="item.brand.id">
					<option value="">--Select--</option>
					<s:iterator value="brandList" id="list">
						<option value = '<s:property value="#list.id" />'> <s:property value="#list.name" /></option>
					</s:iterator>
				</select>
			</td>
		</tr>
		<tr>
			<td class="title">Item Name:</td>
			<td><input type="text" name="item.name"></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Add" /></td>
			
		</tr>
	</table>
</form>
<jsp:include page="../footer.jsp"/>