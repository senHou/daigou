<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery-1.12.3.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
$(document).ready(function(){
	$("#uploadBrandButton").click(function(){
		location.href = "initUploadBrandFile";
		return false;
	});	
});
</script>
</head>
<body>
	<div class="contanier">
		
		<jsp:include page="../header.jsp"/> 
		<div class = "content">
			<form id="brandId" method="post" action="addBrand">
				<table id="addBrandTable" class="addTalbe">
					<tr>
						<td>Brand Name:</td>
						<td><input type="text" value='<s:property value="name"/>' name="brand.name" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Add" /></td>
						<td><button id="uploadBrandButton">upload</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>