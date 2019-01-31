<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>List Of All Users:</h1>
<% 

%>

<table border="2" cellpadding="3px;" cellspacing="5px;">
		
		<th>Name:</th>
		<th>Email</th>
		<th>Gender</th>
		<th>Action</th>

<c:if test="${not empty list}">
    <c:forEach items="${list}" var="list">
     
     <tr>
     <td><c:out value="${list.name}"/></td>
      <td><c:out value="${list.email}"/></td>
      <td><c:out value="${list.gender}"/></td>
      
      <td><a href="delete?email=${list.email}">Delete</a> </td>
      <td><a href="edit?email=${list.email}">Edit</a></td>
       </tr>
</c:forEach>
</c:if>



</table>
<!-- <h2>Delete User From here</h2>

<form action="delete" method="get">
Enter Email :<input type="text" name="email">
<input type="submit" value="Delete User">
</form>

 -->
<br /><br /><br /><br /><br /><br /><br /><br />
<form action="update" method="get">

Enter Email: <input type="text" name="email" /><br />
Enter Name: <input type="text" name="name" /><br />
Enter Passowrd: <input type="text" name="password" /><br />
<input type="submit" value="Update">

</form>

<!-- <a href="update">click here to update a User</a> -->

</body>
</html>