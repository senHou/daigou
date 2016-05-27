<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp"/> 
<title>Upload Brand</title>

<div>
	<h4>Brand Upload</h4>
</div>
<form action="uploadBrandFile" method="post" enctype="multipart/form-data">
	<table class="uploadTable">
       	<tr>
       		<td>Select file to upload:</td>
       		<td> <input type="file" name="fileName" size="60" /></td>
       	</tr>
       	<tr>
       		<td><input type="submit" value="Upload" /></td>
       	</tr>
       </table>
</form>
<jsp:include page="../footer.jsp"/>