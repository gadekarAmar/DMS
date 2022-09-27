<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>billing page</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 15px;
}
</style>
</head>
<body>
<jsp:include page="../admin/Home.jsp"></jsp:include>


<div style="margin-left:25%;padding:1px 16px;height:300px;margin-top:5%;">
	<%-- <h3>${requestScope.msg}</h3> --%>
	<h3>Name of User:${requestScope.user.getName()}
		${requestScope.user.getLastName()} &nbsp &nbsp &nbsp<br> Cattle
		type:${requestScope.user.getCattle()}</h3>
	<h3>Bill from ${requestScope.startDate} to ${requestScope.endDate}
	</h3>
<spring:url var="emailUrl" value="/email/sendEmail?toEmail=${requestScope.user.getEmail()}&body=${requestScope.emailBody}"/>
	<h5><a  href="${emailUrl}">SendBill-Email</a></h5>
	<table>
		<tr>
			<th>Date</th>
			<th>Session</th>
			<th>Milk in Liters</th>
			<th>fate</th>
			<th>fateRate</th>
			<th>Total price</th>
		</tr>
		<c:forEach var="milklist" items="${requestScope.milklist}">
			<tr>

				<td>${milklist.getDate()}</td>
				<td>${milklist.getSession()}</td>
				<td>${milklist.getLiter()}</td>
				<td>${milklist.getFate()}</td>
				<td>${milklist.getFateRate()}</td>
				<td>${milklist.getPrice()}rs</td>
			</tr>

		</c:forEach>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>${requestScope.bill}rs</td>
		</tr>

	</table>
	<h5>Total Bill:${requestScope.bill}</h5>
	
</div>

</body>
</html>