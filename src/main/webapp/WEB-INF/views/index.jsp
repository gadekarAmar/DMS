<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- import spring supplied JSP tag lib -->
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <h5>Welcome 2 Spring Boot @ ${requestScope.ts}</h5>
	<h5 style="color: red;">${requestScope.mesg}</h5>
	<spring:url var="url" value="/customer/showForm"/>
	<a href="${url}"/>Click Here To Go at Milk Managment Page</a><br>
	<spring:url var="url1" value="/customer/bill"/>
	<a href="${url1}"/>Click Here to to Billing page</a> --%>
	
	<p><a href="user/login">User Login</a></p>
	<p><a href="admin/login">Admin Login</a></p>
	
</body>
</html>