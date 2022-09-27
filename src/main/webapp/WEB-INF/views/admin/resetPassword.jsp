<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reset Password</title>
</head>
<body>
<jsp:include page="../customer/header.jsp"></jsp:include>
<h3>reset passowrd</h3>
<h3 style="color:red;">${requestScope.msg}</h3>
<!-- <spring:url var="reset" value="/forgot/resetPassword"/><br> -->
<form action="resetPassword" method="post">
<Input type="password" placeholder="reset password" name="password"><br><br>
<input type="submit" value="reset password">
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>