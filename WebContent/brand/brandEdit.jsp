<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../header.jsp"/> 
<title>Display Brand</title>
<script>
$(document).ready(function(){
	
});
</script>
 <div class ="editDiv">
	<form id = "editForm" class = "editForm" method="post" action ="editBrand">
		<table class = "editTable"> 
			<tr>
				<td>brand Id:</td>
				<td><input type="text" readonly="readonly" name="brand.id" value="<s:property value="brand.id" />" /></td>
			</tr>
			
			<tr>
				<td>Brand Name:</td>
				<td><input type="text"  name="brand.name" value="<s:property value="brand.name" />" /></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="update" /></td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="../footer.jsp"/>