<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<title>billing page</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div style="margin-left:25%;padding:1px 16px;height:300px;margin-top:5%;"> 
		<table>
		<caption><b>Milk Report :</b></caption>
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
	</div>
	<jsp:include page="../admin/footer.jsp"></jsp:include>
</body>
</html>