<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file list</title>
</head>
<body>
	<h3>[<a href="07.file-upload.jsp">파일 업로드</a>]</h3>
	<hr>
	<%
		// 업로드된 파일의 컴퓨터 경로 가져오기
		String path = application.getRealPath("/upload-files"); // 웹 경로에 해당하는 컴퓨터 경로 찾기
		
		File dir = new File(path); // File : file 또는 directory를 관리(생성,삭제,이동,크기확인, ....)하는 클래스
		File[] files = dir.listFiles(); // directory에 포함된 모든 파일과 디렉터리를 배열로 반환
	%>
	<h2>File List</h2>
	<% for (int i = 0; i < files.length; i++) { %>
		<h3><%= i + 1 %>. <%= files[i].getName() %></h3>
	<% } %>
	
	
</body>
</html>






