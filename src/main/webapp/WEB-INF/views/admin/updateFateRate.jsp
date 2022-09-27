<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update fat rate</title>

<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 15px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script> 
<script type="text/javascript">
$(document).ready(function(){
	  $("button").click(function(){
		  if( !confirm("Do you Want upate fate Rate"))
			  {
			   $("form").attr("action","/project/admin/setFate")
			  }
	   	
	  });
	});

</script>
</head>
<body>
<jsp:include page="Home.jsp"></jsp:include>
<div style="margin-left:25%;padding:1px 16px;height:300px;margin-top:5%;">
<form method="post">

		<table>

			<tr>
				<th>Id</th>
				<th>Cattle Type</th>
				<th>FateRate</th>
			</tr>


			<tr>

				<td>${requestScope.rate.id}</td>
				<td>${requestScope.rate.cattle}</td>
				<td><input type="text" name="fateRate"
					value="${requestScope.rate.fateRate}" required="required"></td>



			</tr>
			<tr>
				<td></td><td><td><button type="submit">Update</button></td>
			</tr>
             
		</table>
	</form>

</div>
</body>
</html>