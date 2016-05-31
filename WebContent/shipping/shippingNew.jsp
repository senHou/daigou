<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../header.jsp"/> 
<title>add shipping</title>
<script type="text/javascript">

$(document).ready(function(){
	$("#datepicker").datepicker({dateFormat: "yy/mm/dd"});
	$("#shippingDetailTable").on("change",".brandSelect",function(){
		var brandId = $(this).val();
		var obj = $(this).parent().parent();
		if (brandId != "") {
			$.ajax({
				url: "printItemOptions", 
				type:"post",
				contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				data:{"brandId": brandId},
				dataType:"text",
				success: function(result){
					$(obj).find(".itemSelect").html("");
					$(obj).find(".itemSelect").append("<option value=''>--Select--</option>"+result);
				}
			});
		}
	});
	
	$("#addButton").click(function(){
		var numOfRow = $("#shippingDetailTable .undeleteble").length + $("#shippingDetailTable .deleteble").length;
		var obj = $("#shippingDetailTable th");
		appendTr(numOfRow,obj);
		return false;
	});


	$("#shippingDetailTable").on("click",".deleteButton",function(){
		$(this).parent().parent().remove();
		updateTrIndex();
		return false;
	});
});
function appendTr(numOfRow,obj){
	var html = "";
	html +="<tr class='deleteble'>";
	$(obj).each(function(){
		if($(this).attr("id") != null){
			
			var tmp_array = $(this).attr("id").split("_");
			if ($(this).attr("type") == "input"){
				html +="<td><input type='text' name='"+tmp_array[0]+"["+numOfRow+"]."+tmp_array[1]+"' /></td>";
			}else if ($(this).attr("type") == "select") {
				var index = $(this).index();
				var selectHtml = $("#undeletebleTr").find("td:eq("+index+")").find("select").html();
				var selectClass = $("#undeletebleTr").find("td:eq("+index+")").find("select").attr("class");
				if (tmp_array[1] == "item.id") {
					selectHtml = "<option value=''>--Select--</option>";
				}
				html += "<td><select class='"+selectClass+"' name='"+tmp_array[0]+"["+numOfRow+"]."+tmp_array[1]+"' >"+selectHtml+"</select></td>";
			}
		}
	});
	html +="<td><button class='deleteButton' num="+numOfRow+">delete</button></td></tr>";
	$("#appendBefore").before(html);
}

function updateTrIndex() {
	var obj = $("#shippingDetailTable");

	var trs = $(obj).find("tr[class='deleteble']");
	var count = 1;
	$(trs).each(function(){
		var tds = $(this).find("td");
		$(tds).each(function(){
			if ($(this).children().attr("name") == undefined || $(this).children().attr("name") == "") {
				return;
			}else {
				var value = $(this).children().attr("name").replace(/\d+/,count);	
				
				$(this).children().attr("name",value);
			}
		});
		count++;
	});
}
function addNewCustomer(){
	location.href = "initAddCustomer";
	return false;
}
</script>

<form name="addShipping" action="addShipping" method="post">
	<table id="addShippingTable" class="addTalbe" cellspacing="0">
		<s:if test="%{errorMessage != null}">
			<tr>
				<td colspan="2" class = "error">
					<s:property value="errorMessage" />
				</td>
			</tr>
		</s:if>
		<tr>
			<td class="title">Shipping No：</td>
			<td><input type="text" name="shipping.shippingNo" value="<s:property value= 'shipping.shippingNo'/>" /></td>
		</tr>
		<tr>
			<td class="title">receiver：</td>
			<td>
				<select name="shipping.customer.id">
					<option value="">--Select--</option>
					<s:iterator value="customerList" id="list">
						<option value = '<s:property value="#list.id" />'> <s:property value="#list.name" />-<s:property value="#list.id" /></option>
					</s:iterator>
				</select>
				<button name="addNewCustomerButton" onclick="return addNewCustomer();" >Add New</button>
			</td>
		</tr>
		<tr>
			<td class="title">Date:</td>
			<td><input type="text" name="date"  id="datepicker"/></td>
		</tr>
		<tr>
			<td class="title">Mobile：</td>
			<td><input type="text" name="shipping.phoneNumber" /></td>
		</tr>
		
		<tr>
			<td class="title">Shipping Company:</td>
			<td><select name="shipping.shippingCompany.id" >
					<option value="">--Select--</option>
					<s:iterator value="shippingCompanyList" id="list">
						<option value = '<s:property value="#list.id" />'> <s:property value="#list.name" /></option>
					</s:iterator>
				</select>
			</td>
		</tr>
		<tr>
			<td class="title">Post Address：</td>
			<td><input type="text" name="shipping.address" size = "40" /></td>
		</tr>
		<tr>
			<td class="title">Agent</td>
			<td><input type="text" name="shipping.agent" /></td>
		</tr>
	</table>
	
	<table id = "shippingDetailTable">
		<tr>
			<th id = "detailList_shippingNo" type="input">Shipping No.</th>
			<th id = "brand" type="select">Brand</th>
			<th id = "detailList_item.id" type="select">Item</th>
			<th id = "detailList_soldPrice" type="input">Sold Price</th>
			<th id = "detailList_quantity" type="input">Quantity</th>
			<th>option</th>
		</tr>
		<tr id = "undeletebleTr" class="undeleteble">
			<td><input type="text" name="detailList[0].shippingNo"/></td>
			<td>
				<select class = "brandSelect">
					<option value="">--Select--</option>
					<s:iterator value="brandList" id="list">
						<option value = '<s:property value="#list.id" />'> <s:property value="#list.name" /></option>
					</s:iterator>
				</select>
			</td>
			<td>
				<select class="itemSelect" name="detailList[0].item.id">
					<option value="">--Select--</option>
				</select>
			</td>
			<td><input type="text" name="detailList[0].soldPrice"/></td>
			<td><input type="text" name="detailList[0].quantity"/></td>
		</tr>
		<tr id="appendBefore">
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><button id="addButton">add</button></td>
		</tr>
		<tr id="appendBefore">
			<td colspan="6" align="center">
				<input type="submit" name="Submit" value="Submit" />
			</td>
		</tr>
	</table>
	
</form>
<jsp:include page="../footer.jsp"/>