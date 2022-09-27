<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>users billing page</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div style="margin-left:25%;padding:1px 16px;height:300px;margin-top:5%;"> 
<h3> Welcome to Billing page</h3>
 
 <form action="${url}" method="post">
 <h3>${requestScope.userBill}</h3>
		<table>
			<tr>
				<td>Enter Date From</td>
				<td><input type="date" name="from" required /></td>
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
<jsp:include page="../admin/footer.jsp"></jsp:include>
<%-- <jsp:include page="../admin/footer.jsp"></jsp:include> --%>
</body>
</html>