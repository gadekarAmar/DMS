<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>day wise milk report</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 15px;
	
}
table.center{
margin-left:auto;
margin-right:auto;
}
</style>
</head>
<body>
<jsp:include page="Home.jsp"></jsp:include>
<div style="margin-left:25%;padding:1px 16px;height:300px;margin-top:5%;">

<table class="c">
<h3 >Daily Milk Collection report</h3>
<tr><th>id</th><th>session</th><th>Liters</th><th>fate</th><th>faterate</th><th>Date</th><th>total price</th><th>User name</th></tr>
<c:forEach var="list" items="${requestScope.dayWiseList}">

<tr><td>${list.id}</td><td>${list.session}</td><td>${list.liter}</td><td>${list.fate}</td><td>${list.fateRate}</td><td>${list.date}</td><td>${list.price}</td><td>${list.user.name}</td></tr>
</c:forEach>
<tr><td></td><td></td><td></td><td></td><td></td><td></td><td>Total:${requestScope.totalBill}</td><td></td></tr>
</table>
</div>
</body>
</html>