<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<h2>my EL page </h2>
	<%
		request.setAttribute("name","Aryan");
	%>
	
	Old way: <%= request.getAttribute("name") %><br>
	New way(EL): ${name}

</body>
</html>