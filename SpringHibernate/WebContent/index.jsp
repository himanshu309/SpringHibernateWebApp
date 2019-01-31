<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>hello user</h1><br> <br> <br> 
<form action="emp" method="post">

Enter Name: <input type="text" name="name"/><br> 
Enter Password <input type="password" name="password"/><br> 
Enter Email :<input type="text" name="email" /><br> 
Enter Gender : <input type="radio" name="gender" value="Male"/>Male

				<input type="radio" name="gender" value="Female"/>Female<br> 
				
				<input type="submit" value="Register"><br> 
 

</form>
</body>
</html>