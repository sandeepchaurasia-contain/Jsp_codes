<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		Username: <input name="username" />
		password: <input type="password" name="password" />
		<button type="submit">Login</button>
	
	</form>
	<p style="color:red">${error}</p>
	<a href="register.jsp">Create account</a>
</body>
</html>