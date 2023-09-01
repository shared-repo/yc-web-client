<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


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
		                <td></td>
		            </tr>
		            <tr>
		                <th>제목</th>
		                <td></td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td></td>
		            </tr>
		            <tr>
		                <th>작성일</th>
		                <td></td>
		            </tr>
		            <tr>
		                <th>조회수</th>
		                <td></td>
		            </tr>
		            <tr>
		                <th>글내용</th>
		                <td></td>
		            </tr>
		        </table>
		        <div class="buttons">
		        	[ <a href="list">목록보기</a> ]
		        </div>
		    </div>
		</div>   	
	
	</div>
	</div>

</body>
</html>