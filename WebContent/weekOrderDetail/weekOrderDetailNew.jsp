<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery-1.12.3.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Weekly Order Detail</title>
<script>
	$(document).ready(function(){
		$("#brandSelect").change(function(){
			alert($(this).val());
		});
	});
</script>
</head>
<body>
	<div class="contanier">
		<jsp:include page="../header.jsp"/> 
		<div class = "content">
			<form id="addWeekOrderDetailForm" name="addWeekOrderDetail" action="addWeekOrderDetail" method="post">
				<table id="addWeekOrderDetailTable">
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
								<s:iterator value="BrandList" id="list" status="rowstatus">
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
						<td><></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>