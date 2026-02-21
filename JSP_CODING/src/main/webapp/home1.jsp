<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name=request.getParameter("name");
		if(name !=null){
			request.setAttribute("n",name);
		}
	%>
	<form>
		Name: <input name="name"/>
		<input type="submit"/>
	</form>
	
	<h3>Request Data: ${n}</h3>
</body>
</html>