<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP input greeting</title>
</head>
<body>
	<form>
		Name: <input type="text" name="username" />
		<input type="submit" value="Submit"/>
	</form>
	
	<%
		String name=request.getParameter("username");
		if(name != null){
			
		
	%>
		<h3>Hello ,<%=name  %></h3>
		<%
			}
		%>

</body>
</html>