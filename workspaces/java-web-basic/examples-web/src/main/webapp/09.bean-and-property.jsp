<%@ page import="com.exampleweb.dto.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Bean and Property</title>
</head>
<body>

	<% Person person = new Person(); %>
	<jsp:useBean id="person2" class="com.exampleweb.dto.Person" />
	
	<% 
	person.setNo(1);
	person.setName("John Doe");
	person.setEmail("johndoe@example.com");
	person.setPhone("010-9988-3344");
	%>
	<jsp:setProperty name="person2" property="no" value="2" /> <!-- no : setNo -->
	<jsp:setProperty name="person2" property="name" value="Jane Doe" />
	<jsp:setProperty name="person2" property="email" value="janedoe@example.com" />
	<jsp:setProperty name="person2" property="phone" value="010-5469-2231" />
	
	[<%= person.getNo() %>]
	[<%= person.getName() %>]
	[<%= person.getEmail() %>]
	[<%= person.getPhone() %>]
	<hr>
	[<jsp:getProperty name="person2" property="no" />] <!-- no : getNo -->
	[<jsp:getProperty name="person2" property="name" />]
	[<jsp:getProperty name="person2" property="email" />]
	[<jsp:getProperty name="person2" property="phone" />]
	

</body>
</html>








