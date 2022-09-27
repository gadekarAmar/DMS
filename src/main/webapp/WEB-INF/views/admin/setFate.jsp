<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Set fat rate</title>
<style>
table,th,td{
border:1px solid black;
border-collapse:collapse;
padding:15px;
}
</style>
</head>
<body>
<%-- <jsp:include page="header.jsp"></jsp:include>
<jsp:include page="VerNav.jsp"></jsp:include> --%>
<jsp:include page="Home.jsp"></jsp:include>

<div style="margin-left:25%;padding:1px 16px;height:300px;margin-top:5%;">
	<h3>SetFate:${requestScope.msg}</h3>
	<table>

		<tr>
			<th>Id</th>
			<th>Cattle Type</th>
			<th>FateRate</th>
		</tr>

		<c:forEach var="list" items="${requestScope.list}">
			<tr>

				<td>${list.id}</td>
				<td><a href="updateFateRate/${list.id}">${list.cattle}</a></td>
				<td>${list.fateRate}</td>
				


			</tr>
		</c:forEach>

	</table>
	
</div>
<%-- <jsp:include page="footer.jsp"></jsp:include> --%>
</body>
</html>