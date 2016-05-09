<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="contanier">
		<jsp:include page="../header.jsp"/> 
		<div class = "content">
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
		</div>
	</div>
</body>
</html>