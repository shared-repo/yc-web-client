<%@ page import="java.util.Date" %>
<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8" %>
    	 
<%! // 변수 또는 메서드 선언 영역
String msg = "Hello, Test";
String getTimeString() {
	return new Date().toString();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Structure</title>
</head>
<body>

	<!-- HTML 주석 : 서버에서는 주석이 아닙니다. ( 응답 컨텐츠에 포함 ) -->
	<%-- 서버 주석 : 응답 컨텐츠에 포함되지 않습니다. --%>
	
	<% for (int i = 0; i < 3; i++) { %>
	<h2><% out.write(new Date().toString()); %></h2>
	<% } %>
	<hr>
	<h2><%= new Date().toString() %></h2> <%-- <%= : <% out.write --%>
	
	<hr>
	<h2><%= getTimeString() %></h2>

</body>
</html>













