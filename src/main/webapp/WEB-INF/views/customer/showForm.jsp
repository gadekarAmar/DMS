<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>billing page</title>
</head>
<body>
<jsp:include page="../admin/header.jsp"></jsp:include>
<jsp:include page="../admin/VerNav.jsp"></jsp:include>

<div style="margin-left:25%;padding:1px 16px;height:300px;margin-top:5%;">
	<h5>${sessionScope.mesg}</h5>

	<form method="post">
		<table ">
		 <caption><h3>Milk Collection</h3></caption>
		
			<tr>
				<td>User Id</td>
				<td><input type="number" name="user_id" required /></td>

			</tr>
			<tr>
				<td>Enter Session(Morning/Evening)</td>
				<td><select name="session" required>
						<option value="">Select Session</option>
						<option value="MORNING" required>Morning</option>
						<option value="EVENING" required>Evening</option>
				</select></td>

			</tr>
			<tr>
				<td>Enter Milk In Litres</td>
				<td><input type="text" name="liter" required /></td>
			</tr>

			<tr>
				<td>Enter Fate</td>
				<td><input type="text" name="fate" required /></td>
			</tr>

			<tr>
				<td>Enter Date</td>
				<td><input type="date" name="dailyDate" required /></td>
			</tr>

			<tr>
				<td></td><td><input type="submit" value="Add Entry" required /></td>
			</tr>
			<tr><td></<td></td></tr>




		</table>
	</form>
	<h4 style="color:red;">${requestScope.Milkmsg}</h4>
	</div>
	<jsp:include page="../admin/footer.jsp"></jsp:include>
</body>
</html>