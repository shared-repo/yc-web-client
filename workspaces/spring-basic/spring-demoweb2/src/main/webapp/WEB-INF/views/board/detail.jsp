<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>게시판글쓰기</title>
	<link rel="Stylesheet" href="/spring-demoweb/resources/styles/default.css" />
	<link rel="Stylesheet" href="/spring-demoweb/resources/styles/input2.css" />
</head>
<body>

	<div id="pageContainer">
	
		<jsp:include page="/WEB-INF/views/modules/header.jsp" />
		
		<div style="padding-top:25px;text-align:center">
		<div id="inputcontent">
		    <div id="inputmain">
		        <div class="inputsubtitle">게시글 정보</div>
		        <table>
		        	<tr>
		                <th>글번호</th>
		                <td>${ requestScope.board.boardNo }</td>
		            </tr>
		            <tr>
		                <th>제목</th>
		                <td>${ board.title }</td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td>${ board.writer }</td>
		            </tr>
		            <tr>
		                <th>작성일</th>
		                <td><fmt:formatDate value="${ board.regDate }" pattern="yyyy-MM-dd" /></td>
		            </tr>
		            <tr>
		                <th>조회수</th>
		                <td>${ board.readCount }</td>
		            </tr>
		            <tr>
		                <th>첨부파일</th>
		                <td>
		                <c:forEach var="attach" items="${ board.boardAttachList }">
		                	<a href="download?attachNo=${ attach.attachNo }">${ attach.userFileName }</a>
		                	[${attach.downloadCount }]<br>
		                </c:forEach>
		                </td>
		            </tr>
		            <tr>
<c:set var="enter" value="
" />		            
		                <th>글내용</th>
		                <td>${ fn:replace(board.content, enter, "<br>") }</td>
		            </tr>
		        </table>
		        <div class="buttons">
		        	[ <a href="list">목록보기</a> ]
		        	<c:if test="${ not empty sessionScope.loginuser and loginuser.memberId eq board.writer }">
		        	[ <a href="edit?boardNo=${ board.boardNo }">수정</a> ]
		        	[ <a href="javascript:" id="delete-board-lnk">삭제</a> ]
		        	</c:if>
		        </div>
		    </div>
		</div>   	
	
	</div>
	</div>
	<script>
	window.addEventListener('load', function(event) {
		
		const deleteBoardLnk = document.querySelector('#delete-board-lnk');
		deleteBoardLnk.addEventListener('click', function(event) {
			const yes = confirm(${ board.boardNo } + "번 게시물을 삭제할까요?");
			if (yes) {
				location.href = 'delete/' + ${ board.boardNo };
			}
		});
		
	})
	</script>

</body>
</html>








