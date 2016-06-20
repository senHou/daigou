<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../header.jsp"/> 
<title>add shipping companys</title>
<script type="text/javascript">
$(document).ready(function() {
	$(".options").change(function(){
		if ($(this).val() != "") {
			var id = $(this).parent().parent().children(":first-child").text();
			var url = $(this).val() + "?shippingCompany.id="+id;
			redirect(url);
		}
	});
});
</script>

<div class="center">
	<form id="shippingCompanyAddForm" method="post" action="addShippingCompany">
		<table class="center"> 
			<tr>
				<td class="title">Name:</td>
				<td><input type="text" name = "shippingCompany.name" value="<s:property value = "shippingCompany.name"/>" /></td>
			</tr>
			<tr>
				<td class="title">Url:</td>
				<td><input type="text" name = "shippingCompany.url" value="<s:property value = "shippingCompany.url"/>" /></td>
			</tr>
			<tr> 
				<td colspan="2" align="right"><input type="submit" value="Add"/></td>
			</tr>
		</table>
	</form>
</div>

<jsp:include page="../footer.jsp"/>