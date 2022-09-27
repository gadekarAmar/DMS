<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../admin/Home.jsp"></jsp:include>

<div style="margin-left:25%;padding:1px 16px;height:300px;margin-top:5%;">
<spring:url var="imgUrl" value="/Images/ImageUpload/${requestScope.Id}"/><br>
<form action="${imgUrl}" method="post" enctype="multipart/form-data">
<input type="file" name="file"><br><br>
<button type="submit">Upload</button>
</form>
</div>
</body>
</html>