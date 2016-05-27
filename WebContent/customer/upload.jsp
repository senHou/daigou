<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="../header.jsp"/> 
<title>Upload Customer</title>

<div>
	<h4>Customer Upload</h4>
</div>
<form action="uploadCustomerFile" method="post" enctype="multipart/form-data">
	<table class="uploadTable">
		<s:if test="%{errorMessage != null}">
			<tr>
				<td colspan="2" class = "error">
					<s:property value="errorMessage" />
				</td>
			</tr>
		</s:if>
		<s:else>
			<tr>
				<td colspan="2" class = "success">
					
				</td>
			</tr>
		</s:else>
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