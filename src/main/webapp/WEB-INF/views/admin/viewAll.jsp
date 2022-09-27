<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 15px;
}
</style>
<head>
<link rel="stylesheet" type="\cssfiles\table.css"></link>
</head>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script> 
<!-- <script type="text/javascript" src="C:\Users\amarg\Desktop\AdvJava\day17_boot\src\main\resources\static\jquery-3.4.0.js"></script> -->
<script type="text/javascript">
$(document).ready(function(){
	  $(".myClass").click(function(){
		  if( !confirm("plz confirm"))
			  {
			   $("a").attr("href","viewAll")
			  }
	   	
	  });
	});
	


</script>
<title>View All Users</title>
<body>	
<jsp:include page="Home.jsp"></jsp:include>
<div
	style="margin-left: 25%; padding: 1px 16px; height: 300px;margin-bottom:10%">
  
   
	<table style="margin-top: -5%;">
	<caption><h3>All Users:</h3></caption>
	<tr> <h3>${requestScope.Addmsg}</h3></tr>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Surname</th>
			<th>Email</th>
		</tr>

		<c:forEach var="users" items="${requestScope.users}">
			<tr>

				<td>${users.id}</td>
				<td><a href="UserDetails/${users.id}" class="myClass" >${users.name}</a></td>
				<%--                         <td><a href="UserDetails">${users.name}</a></td> --%>
				<td>${users.lastName}</td>
				<td>${users.email}</td>
				<td><a
					href="<spring:url value='/admin/DeleteUser/${users.id}'/>" class="myClass">
						Delete Users</a></td>
				<td><a
					href="<spring:url value='/admin/UpdateUser/${users.id}'/>" class="myClass">
						Update Users</a></td>
				<td><a href="<spring:url value='/admin/AddUser'/>" class="myClass">Add
						Users</a></td>
				<spring:url var="imgUrl" value="/Images/ImageUpload/${users.id}" />
				<br>
				<td><a href="${imgUrl}" class="myClass" >upload image</a>
				<td>
			</tr>
		</c:forEach>

	</table>
	<h3>${requestScope.msg}</h3>
	<h3>${requestScope.deleteMsg}</h3>
	<h3>${requestScope.updateMsg}</h3>
	<h3>${requestScope.ImageMsg}</h3>
</div>
</body>
</html>


















