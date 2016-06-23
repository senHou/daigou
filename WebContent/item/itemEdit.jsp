<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../header.jsp"/> 
<title>Edit Item</title>
<script>
$(document).ready(function(){
	
});
</script>
<div class ="editDiv">
	<form id = "editForm" class = "editForm" method="post" action ="editItem">
		<table class = "editTable"> 
			<tr>
				<td class="title">Item Id:</td>
				<td><input type="text" readonly="readonly" name="item.id" value="<s:property value="item.id" />" /></td>
			</tr>
			
			<tr>
				<td class="title">Brand:</td>
					<td>
						<select name="item.brand.id" class = "brandSelect">
							<s:iterator value="brandList" id="list">
								<s:if test="%{item.brand.id == #list.id}">
									<option value = '<s:property value="#list.id" />' selected="selected" > <s:property value="#list.name" /></option>
								</s:if>
								<s:else>
									<option value = '<s:property value="#list.id" />'> <s:property value="#list.name" /></option>
								</s:else>
							</s:iterator>

						</select>
					</td>
			</tr>
			<tr>
				<td class="title">Item Name:</td>
				<td><input type="text"  name="item.name" value="<s:property value="item.name" />" /></td>
				
			</tr>
			
			<tr>
				<td colspan="2" align="left"><input type="submit" value="update" /></td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="../footer.jsp"/>