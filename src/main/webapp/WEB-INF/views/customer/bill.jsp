<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>billing page</title>
</head>
<body>
<%-- <jsp:include page="../admin/header.jsp"></jsp:include>
<jsp:include page="../admin/VerNav.jsp"></jsp:include>--%>
<jsp:include page="../admin/Home.jsp"></jsp:include>
<div style="margin-left:25%;padding:1px 16px;height:300px;margin-top:5%;"> 
<h3> Welcome to Billing page</h3>
 
 <form action="${url}" method="post">
 <h3>${requestScope.Billmsg}</h3>
 <h3>${requestScope.emailMsg}</h3>
		<table>
			<tr>
				<td>Enter User Id</td>
				<td><input type="number" name="user_id" required /></td>
			</tr>
			<tr>
				<td>Enter Name of User</td>
				<td><input type="text" name="name" required /></td>
			</tr>
			<tr>
				<td>Enter Date From</td>
				<td><input type="date" name="form" required /></td>
			</tr>
			<tr>
				
				<td>To</td>
				<td><input type="date" name="to"  required /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Show Bill" /></td>
			</tr>




		</table>
	</form>
	</div>

<%-- <jsp:include page="../admin/footer.jsp"></jsp:include> --%>
</body>
</html>