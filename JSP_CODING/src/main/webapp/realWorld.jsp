<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String user=request.getParameter("user");
	if(user != null){
		session.setAttribute("loggedUser",user);
	}
	
	String logged=(String)session.getAttribute("loggedUser");
%>

<html>
<body>
	<form>
		username: <input type="text" name="user"/>
		<input type="submit"/>
	</form>
	
	<%
		if(logged !=null){
			
		
	%>
	<h2>welcome , <%= logged %></h2>
	<%
		}
	%>

</body>
</html>