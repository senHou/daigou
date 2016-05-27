<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../header.jsp"/> 
<title>List Item</title>
	<div class="searchPanel">
		<form action="listItem" action="get">
			<table class="searchTable">
				<tr>
					<td>Brand:</td>
					<td>
						<select class = "brandSelect" name="brandId">
							<option value="">--Select--</option>
							<s:iterator value="brandList" id="list">
								<option value = '<s:property value="#list.id" />'> <s:property value="#list.name" /></option>
							</s:iterator>
						</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Search"></td>
				</tr>
			</table>
		</form>
	</div>
	<table class="listTalbe">
		<tr>
			<th>Item Id</th>
			<th>Item Brand</th>
			<th>Item Name</th>
		</tr>
		<s:iterator value="itemList" id="list" status="rowstatus">
			<tr>
				<s:if test="#rowstatus.odd == true">
					<td class = "odd"><s:property value="#list.id" /></td>
					<td class = "odd"><s:property value="#list.brand.name" /></td>
					<td class = "odd"><s:property value="#list.name" /></td>
				</s:if>
				<s:else>
					<td class = "even"><s:property value="#list.id" /></td>
					<td class = "even"><s:property value="#list.brand.name" /></td>
					<td class = "even"><s:property value="#list.name" /></td>
				</s:else>
			</tr>
		</s:iterator>
	</table>

<jsp:include page="../footer.jsp"/>
