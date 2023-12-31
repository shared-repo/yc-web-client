<%@page import="com.demowebsup.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>게시판글쓰기</title>
	<link rel="Stylesheet" href="/demowebsup/styles/default.css" />
	<link rel="Stylesheet" href="/demowebsup/styles/input2.css" />
</head>
<body>

	<div id="pageContainer">
	
		<jsp:include page="/WEB-INF/views/modules/header.jsp" />
		
		<div style="padding-top:25px;text-align:center">
		<div id="inputcontent">
		    <div id="inputmain">
		        <div class="inputsubtitle">게시글 정보</div>
		        <% BoardDto board = (BoardDto)request.getAttribute("board"); %>
		        <table>
		        	<tr>
		                <th>글번호</th>
		                <td><%= board.getBoardNo() %></td>
		            </tr>
		            <tr>
		                <th>제목</th>
		                <td><%= board.getTitle() %></td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td></td>
		            </tr>
		            <tr>
		                <th>작성일</th>
		                <td><%= board.getWriteDate() %></td>
		            </tr>
		            <tr>
		                <th>조회수</th>
		                <td></td>
		            </tr>
		            <tr>
		                <th>글내용</th>
		                <td><%= board.getContent() %></td>
		            </tr>
		        </table>
		        <div class="buttons">
		        	[ <a href="list.action">목록보기</a> ]
		        </div>
		    </div>
		</div>   	
	
	</div>
	</div>

</body>
</html>