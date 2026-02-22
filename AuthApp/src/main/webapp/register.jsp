<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="register" method="post">
		Username: <input name="username"/>
		Password: <input type="password" name="password"/>
		<button type="submit">Register </button>
	
	</form>
	<p style="color:red">${error}</p>
	<a href="login.jsp">Go to Login</a>
</body>
</html>