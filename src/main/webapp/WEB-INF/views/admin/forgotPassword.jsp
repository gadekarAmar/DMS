<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reset Password</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	 $("#submit").click(function(){
		 var id= $("#id").val();
		 var email= $("#email").val();
		 if(id.trim()==" " || email.trim()==" ")
			 {
			    alert("id should not empty");
			 }
	
		 
	 });
	
});

</script>
</head>
<body>
	<jsp:include page="../customer/header.jsp"></jsp:include>


<div style="margin-left:25%;padding:1px 16px;height:300px;margin-top:5%;">
<h3 style="color:red;">Forgot Password</h3>
<h3 style="color:red;">${requestScope.msg}</h3>
<form method="post">
<Input type="number" placeholder="Enter User id" name="id" id="id" required="required"><br><br>
<Input type="email" placeholder="Enter Email" name="email" id="email" required="required"><br><br>
<input type="submit" value="send otp" id="submit">
</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>