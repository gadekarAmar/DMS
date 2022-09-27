<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Admin Register</title>
<style>
body{
  background-color: #f1f1f1;
}
</style>
</head>
<body>
	

	<div
		style="margin-left: 25%; padding: 1px 16px; height: 300px; margin-top: 10%;">
		<form method="post">
               <table style="margin-top:-30%;">
               <caption><h3>Admin Register:</h3></caption>
          
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
    <tr><td><button type="submit" class="btn btn-default" required>Insert</button></td></tr>
			</table>
		</form>

	</div>

</body>
</html>