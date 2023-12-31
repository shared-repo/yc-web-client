<%@page import="com.demowebsup.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>    

<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>게시글 목록</title>
	<link rel="Stylesheet" href="/demowebsup/styles/default.css" />
	<style>
	a { text-decoration: none }
	</style>
</head>
<body>

	<div id="pageContainer">
	
	
		<jsp:include page="/WEB-INF/views/modules/header.jsp" />
		
		<div style="padding-top:25px;text-align:center">
		
			[ <a href="write.action">게시글 쓰기</a> ]
			<br /><br />
			
			<table border="1" style="width:600px;margin:0 auto">
				<tr style="background-color:orange;height:30px">
					<th style="width:100px">번호</th>
					<th style="width:300px">제목</th>
					<th style="width:125px">작성자</th>
					<th style="width:50px">조회수</th>
					<th style="width:125px">작성일</th>					
				</tr>
				<% ArrayList<BoardDto> boards = (ArrayList<BoardDto>)application.getAttribute("boards"); %>
				<% for (BoardDto board : boards) { %>
				<tr style="height:30px">
					<td><%= board.getBoardNo() %></td>
					<td style="text-align:left; padding-left:5px;">
						<a href="detail.action?boardno=<%= board.getBoardNo() %>"><%= board.getTitle() %>(상대경로)</a>
						<br>
						<a href="/demowebsup/board/detail.action?boardno=<%= board.getBoardNo() %>"><%= board.getTitle() %>(절대경로)</a>
					</td>
					<td></td>
					<td></td>
					<td><%= board.getWriteDate() %></td>
				</tr>
				<% } %>
								
			</table>
			
			<br><br>
			
			<br /><br /><br /><br />
		
		</div>
		
	</div>
		

</body>
</html>











