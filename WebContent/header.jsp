<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/jqpagination.css">
<link rel="stylesheet" type="text/css" href="js/jquery-ui.css">
<script src="js/jquery-1.12.3.js"></script>
<script src="js/jquery.jqpagination.js"></script>
<script src="js/jquery-ui.js"></script>
<script>
$(document).ready(function() {
	$("#datepicker").datepicker({dateFormat: "yy/mm/dd"});
	
	$("#updateListButton").click(function(){
		$.ajax({
			url: "setList", 
			data:"",
			type:"post",
			dataType:"text",
			success: function(result){
				alert("updated!");
			}
		});
		
		return false;
	});
});

function redirect(url) {
	location.href = url;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="contanier">
	<div class = "content">
		<div class = "header backgroundColor80ff00">
			<div class = "navi">
				<li>
					<ol><a href="home">Home</a></ol>
					<ol><a href="listItem">Item</a></ol>
					<ol><a href="listBrand">Brand</a></ol>
					<ol><a href="listCustomer">Customer</a></ol>
					<ol><a href="listShipping">Shipping</a></ol>
					<ol><a href="listShippingCompany">Shipping Company</a></ol>
					<ol><a href="initAddWeekOrderDetail">Weekly Order</a></ol>
					<ol><a href="initUpdateDataList">Maintenance</a></ol>
				</li>
			</div>
		</div>