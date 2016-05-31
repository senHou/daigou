<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../header.jsp"/> 
<title>display shipping</title>
<script type="text/javascript">
$(document).ready(function() {

	$('.pagination').jqPagination({
		link_string	: '/?pageNo={page_number}',
		max_page	: 40,
		paged		: function(pageNo) {
			
		}
	});

});
</script>
	<div class="gigantic pagination">
		<li>
			<ol> <a href="#" class="first" data-action="first">&laquo;</a></ol>
			<ol> <a href="#" class="previous" data-action="previous">&lsaquo;</a></ol>
			<ol> <input type="text" readonly="readonly" /></ol>
			<ol> <a href="#" class="next" data-action="next">&rsaquo;</a></ol>
			<ol> <a href="#" class="next" data-action="last">&raquo;</a></ol>
		</li> 
	</div>

<jsp:include page="../footer.jsp"/>