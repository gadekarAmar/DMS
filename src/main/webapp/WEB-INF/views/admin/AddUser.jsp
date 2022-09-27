<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>
	<%-- <jsp:include page="header.jsp"></jsp:include>
<jsp:include page="VerNav.jsp"></jsp:include> --%>
	<jsp:include page="Home.jsp"></jsp:include>

	<div
		style="margin-left: 25%; padding: 1px 16px; height: 300px; margin-top: 5%;">
		<form method="post">
               <table style="margin-top:-30%;">
               <caption><h3>Add user:</h3></caption>
          
			<tr>
				<td><label for="name">Name:</label></td>
				<td><input type="text" class="form-control" id="name"
					name="name" required></td><br><br>
			</tr>



			<tr>
				<td><label for="lastName">LastName:</label></td>
				<td><input type="text" class="form-control" id="lastName"
					name="lastName" required></td><br><br>
			</tr>




			<tr>
				<td><label for="password">password:</label></td>
				<td><input type="password" class="form-control" id="password"
					name="password" required></td><br><br>
			</tr>



			<tr>
				<td><label for="address">Address:</label></td>
				<td><input type="text" class="form-control" id="laddress"
					name="address" required></td><br><br>
			</tr>



			<tr>
				<td><label for="email">EMail</label></td>
				<td><input type="email" class="form-control" id="email"
					name="email" required></td><br><br>
			</tr>

            
			<tr>
				<td><label for="role">Role:</label></td>
				<td><select name="role" id="role" required="required">
				<option value="ADMIN">ADMIN</option>
				<option value="USER">USER</option>
				
				</select></td><br><br>
			</tr>



			<tr>
				<td><label for="cattleType">CattleType:</label></td>
				<td><select name="cattleType"id="cattleType" required="required">
				<option value="COW">COW</option>
				<option value="BUFFEALO">BUFFEALO</option>
				
				</select></td><br><br>
			</tr>




			<tr><td><button type="submit" class="btn btn-default" required>Insert</button></td></tr>
			</table>
		</form>

	</div>
	<%-- <jsp:include page="footer.jsp"></jsp:include> --%>
</body>
</html>