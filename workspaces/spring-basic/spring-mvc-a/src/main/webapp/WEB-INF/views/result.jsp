<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Result Page</title>
</head>
<body>

	<h3>DATA1 : <%= request.getAttribute("data1") %> / DATA2 : <%= request.getAttribute("data2") %></h3>
	
	<h3><%= request.getAttribute("person") %></h3>
	<h3><%= request.getAttribute("person2") %></h3>
	
	<h3>NAME : <%= request.getAttribute("name") %> / AGE : <%= request.getAttribute("age") %></h3>
</body>
</html>

