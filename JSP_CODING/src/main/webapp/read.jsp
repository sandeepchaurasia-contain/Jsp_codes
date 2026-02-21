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
    Cookie[] cookies = request.getCookies();
    String user = null;
    if(cookies != null){
        for(Cookie c: cookies){
            if(c.getName().equals("user")){
                user = c.getValue();
            }
        }
    }
    request.setAttribute("u", user);
%>

<h3>Cookie User: ${u}</h3>

</body>
</html>