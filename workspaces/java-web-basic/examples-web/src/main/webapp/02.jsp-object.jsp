<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Object</title>
</head>
<body>

	<% 
	pageContext.setAttribute("name", "John Doe");
	request.setAttribute("email", "johndoe@example.com");
	session.setAttribute("phone", "010-6547-8963");
	application.setAttribute("address", "seoul, korea");
	%>
	
	<h2><%= pageContext.getAttribute("name") %></h2>
	<h2><%= request.getAttribute("email") %></h2>
	<h2><%= session.getAttribute("phone") %></h2>
	<h2><%= application.getAttribute("address") %></h2>

</body>
</html>