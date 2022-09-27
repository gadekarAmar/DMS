<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<h5>${requestScope.admin.name}</h5>
	<h5>${requestScope.user.name}</h5>
	<h5>You have logged out...</h5>
	<h5>Redirecting to home page....</h5>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>