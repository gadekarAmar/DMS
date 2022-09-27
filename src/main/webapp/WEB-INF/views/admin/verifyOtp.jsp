<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>verify otp</title>
</head>
<body>
<jsp:include page="../customer/header.jsp"></jsp:include>
<h3>Verify Otp</h3>
<h3 style="color:red;">${requestScope.msg}</h3>
<spring:url var="Url" value="/forgot/verify"/><br>
<form action="${Url}" method="post">
<Input type="email" placeholder="Enter Email" name="email" required="required"><br><br>
<Input type="text" placeholder="Enter OTP" name="Otp" required="required"><br><br>
<input type="submit" value="Verify otp" required="required">
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>