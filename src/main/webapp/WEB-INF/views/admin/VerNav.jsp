<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
  margin: 0;
  background-color: #f1f1f1;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  width: 25%;
  background-color: #f1f1f1;
  position: fixed;
  height: 100%;
  overflow: auto;
}

li a {
  display: block;
  color: #000;
  padding: 8px 16px;
  text-decoration: none;
}

li a.active {
  background-color: #04AA6D;
  color: white;
}

li a:hover:not(.active) {
  background-color: #555;
  color: white;
}
</style>
</head>
<body>
	
	<h3>${requestScope.LoginMsg}${requestScope.admin.email}</h3>
	<!-- <div class="form-group">
    <a href="viewAll"   class="btn btn-default" style="border:solid ">View All Users</a>
       <br />
          <hr />
           </div> -->
	<spring:url var="url1" value="/admin/viewAll" />
<spring:url var="url2" value="/customer/showForm" />
<spring:url var="url3" value="/customer/bill" />
<spring:url var="url4" value="/admin/setFate" />
<spring:url var="url5" value="/admin/DayWiseDetails" />
<spring:url var="url6" value="/admin/AddUser" />


<ul>
<li><a href="${url6}" />Add user</a></li>
  <li><a  href="${url1}">ViewAll</a></li>
  <li><a href="${url2}" />Milk Collcetion</a></li>
  <li><a href="${url3}" />Generete Bill</a></li>
 <li><a href="${url4}" />Set Fat rate</a></li>
 <li><a href="${url5}" />Daily Milk Report</a></li>

</ul>



</body>
</html>