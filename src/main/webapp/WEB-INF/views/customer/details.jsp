<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 15px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<%-- <jsp:include page="header.jsp"></jsp:include> --%>


<div style="margin-left:25%;padding:1px 16px;height:300px;margin-top:5%;">
<h3>User:${sessionScope.user.name} ${sessionScope.user.lastName}</h3>
<img src="C:\Users\amarg\Desktop\AdvJava\day17_boot\src\main\webapp\images\Diamond.png" alt="image not found" >

<table border="1">
<tr><td>Name:</td><td>${sessionScope.user.name}</td></tr>
<tr><td>LastName:</td><td>${sessionScope.user.lastName}</td></tr>
<tr><td>Email:</td><td>${sessionScope.user.email}</td></tr>
<tr><td>Address:</td><td>${sessionScope.user.address}</td></tr>

<tr><td>Cattle Type:</td><td>${sessionScope.user.cattle}</td></tr>
<tr><td>Role:</td><td>${sessionScope.user.role}</td></tr>


<spring:url var="report" value="/customer/milkReport/${sessionScope.user.id}" />
<tr><td>Milk Report :</td><td><a href=${report} >View Report</a></td></tr>


</table>
</div>
<jsp:include page="../admin/footer.jsp"></jsp:include>
</body>
</html>