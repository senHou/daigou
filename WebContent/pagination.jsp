<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
$(document).ready(function() {
	$('.pagination').jqPagination({
		link_string :'listShipping?pageNo={page_number}',
		max_page	: $("#maxPage").val(),
		paged		: function(pageNo) {
			
			var url = "ajaxListByPage?pageNo="+pageNo;
			var data = $("#searchForm").serialize();
			data = decodeURIComponent(data, true ); 
			$("a").addClass("disabled");
			$.ajax({
				url: url, 
				type:"post",
				data:data,
				contentType: "application/x-www-form-urlencoded; charset=utf-8", 
				dataType:"text",
				success: function(result){
					$("a").removeClass("disabled");
					$(".removable").remove();
					$(".searchResultTable").append(result);
				}
			});
		}
	});
});
</script>

	<div class="gigantic pagination">
	    <a href="#" class="first" data-action="first">&laquo;</a>
	    <a href="#" class="previous" data-action="previous">&lsaquo;</a>
	    <input type="text" readonly="readonly" />
	    <a href="#" class="next" data-action="next">&rsaquo;</a>
	    <a href="#" class="last" data-action="last">&raquo;</a>
	</div>