<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery-1.12.3.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Item</title>
</head>
<body>
	<div class="contanier">
		
		<jsp:include page="../header.jsp"/> 
		<div class = "content">
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
		</div>
		
	</div>
</body>
</html>