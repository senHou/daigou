<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../header.jsp"/> 
<title>Create Weekly Order Detail</title>
<script>
	$(document).ready(function(){
		$("#brandSelect").change(function(){
			alert($(this).val());
		});
	});
</script>
<form id="addWeekOrderDetailForm" name="addWeekOrderDetail" action="addWeekOrderDetail" method="post">
	<table id="addWeekOrderDetailTable" class="addTalbe">
		<tr>
			<th class = "backgroundColor80ff00">Brand</th>
			<th class = "backgroundColor80ff00">Item</th>
			<th class = "backgroundColor80ff00">Quantity</th>
			<th class = "backgroundColor80ff00">Create Date</th>
			<th class = "backgroundColor80ff00">Action</th>
		</tr>
		<tr id="">
			<td>
				<select id="brandSelect" name="brandId" style="width:150px">
					<option class="even" value= "">Select</option>
					<s:iterator value="brandList" id="list" status="rowstatus">
					 	<s:if test="#rowstatus.odd == true">
							<option class="odd" value = '<s:property value="#list.id" />'><s:property value="#list.name" /></option>
						</s:if>
						<s:else>
							<option class="even" value = '<s:property value="#list.id" />'><s:property value="#list.name" /></option>
						</s:else>
					</s:iterator>
				</select>
			</td>
		</tr>
		
		<tr>
			<td></td>
		</tr>
	</table>
</form>
<jsp:include page="../footer.jsp"/>