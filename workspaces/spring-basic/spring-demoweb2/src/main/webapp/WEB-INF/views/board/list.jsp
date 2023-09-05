<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>게시글 목록</title>
	<link rel="Stylesheet" href="/spring-demoweb/resources/styles/default.css" />
	<style>
	a { text-decoration: none }
	.deleted { color: lightgray; }
	</style>
</head>
<body>

	<div id="pageContainer">
	
		<jsp:include page="/WEB-INF/views/modules/header.jsp" />
		
		<div style="padding-top:25px;text-align:center">
		
			[ <a href="write">게시글 쓰기</a> ]
			<br /><br />
			
			<table border="1" style="width:600px;margin:0 auto">
				<tr style="background-color:orange;height:30px">
					<th style="width:100px">번호</th>
					<th style="width:300px">제목</th>
					<th style="width:125px">작성자</th>
					<th style="width:50px">조회수</th>
					<th style="width:125px">작성일</th>					
				</tr>
				<c:forEach var="board" items="${ boardList }"><!-- request.getAttribute("boardList") -->
				<tr style="height:30px">
					<td>${ board.boardNo }</td>
					<td style="text-align:left;padding-left:10px">
					<c:choose>
						<c:when test="${ not board.deleted }">
						<a href="detail?boardNo=${ board.boardNo }&pageNo=${ pageNo }">${ board.title }</a>
						</c:when>
						<c:otherwise>
						<span class="deleted">${ board.title } [삭제된 글]</span>
						</c:otherwise>
					</c:choose>
					</td>
					<td>${ board.writer }</td>
					<td>${ board.readCount }</td>
					<td><fmt:formatDate value="${ board.regDate }" pattern="yyyy-MM-dd" /></td>					
				</tr>
				</c:forEach>
							
			</table>
			
			<br><br>
			
			${ pager }
			
			<br /><br /><br /><br />
		
		</div>
		
	</div>
		

</body>
</html>











