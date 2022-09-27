<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div style="margin-left: 25%; padding: 1px 16px; height: 100px;">
	<spring:url var="url6" value="/project/admin/UpdateUser/${requestScope.user.id}" />
		<form action="/project/admin/UpdateUser/${requestScope.user.id}"  method="post">
		
		<table style="margin-top:-20%;">
		   <tr><td><h3>Update user:</h3></td></tr>
		<tr>
			<td><label for="name">Name:</label></td>
			<td><input type="text" class="form-control" id="name"
				name="name" value="${requestScope.user.name}"></td>
		</tr>

		<br> <br>

		<tr>
			<td><label for="lastName">LastName:</label></td>
			<td><input type="text" class="form-control" id="lastName"
				name="lastName" value="${requestScope.user.lastName}"></td>
		</tr>
		<br> <br>



		<tr>
			<td><label for="password">password:</label></td>
			<td><input type="text" class="form-control" id="password"
				name="password" value="${requestScope.user.password}"></td>
		</tr>
		<br> <br>


		<tr>
			<td><label for="address">Address:</label></td>
			<td><input type="text" class="form-control" id="laddress"
				name="address" value="${requestScope.user.address}"></td>
		</tr>
		<br> <br> 

		<tr>
			<td><label for="email">EMail</label></td>
			<td><input type="email" class="form-control" id="email"
				name="email" value="${requestScope.user.email}"></td>
		</tr>
		<br> <br>





		<td><label for="cattleType">CattleType:</label></td>
		<td><select name="cattleType" id="cattleType" required="required"
			value="${requestScope.user.cattle}"><br>
				<br>
				<option value="COW">COW</option>
				<option value="BUFFEALO">BUFFEALO</option>

		</select></td> <br> <br>
		</tr>





		<tr>
			<td><label for="role">Role:</label></td>
			<td><select name="role" id="role" required="required"
				value="${requestScope.user.role}">
					
					<option value="USER">USER</option>

			</select></td>
			<br>
			<br>
		</tr>



		<tr>
			<td><button type="submit" class="btn btn-default">Insert</button></td>
		</tr>
		</form>
		</table>
	</div>
	<jsp:include page="../admin/footer.jsp"></jsp:include>
</body>
</html>