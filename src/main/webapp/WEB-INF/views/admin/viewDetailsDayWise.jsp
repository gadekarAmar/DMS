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
<jsp:include page="Home.jsp"></jsp:include>
<div style="margin-left:25%;padding:1px 16px;height:300px;margin-top:5%;">
 <h3 style="background-cloor:red;">${requestScope.msg}</h3>
 <spring:url var="Url" value="/admin/DayWiseDetails"/>
<form action="${Url}" method="post">
<h3>Select date:</h3>
<input type="date" name="date" id="myDate" value="" required><br><br>
<button type="submit">Submit</button>
</form>
</div>
</body>
</html>