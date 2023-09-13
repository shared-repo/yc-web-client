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
		        <form action="write" method="post" enctype="multipart/form-data">
		        <table>
		            <tr>
		                <th>제목</th>
		                <td>
		                    <input type="text" name="title" style="width:580px">
		                </td>
		            </tr>
		            <tr>
		                <th>작성자</th>
		                <td>
		                	
		                	${ loginuser.memberId }
		                	<input type="hidden" name="writer" value="${ loginuser.memberId }">
		                	
		                	<%-- 
		                	<input type="text" name="writer" value="${ loginuser.memberId }" 
		                		   style="width:580px" readonly>
		                	--%>
		                </td>
		            </tr>
		            <tr>
		                <th>첨부파일</th>
		                <td>
		                	<input type="file" name="attach" style="width:580px">
		                </td>
		            </tr>
		            <tr>
		                <th>글내용</th>
		                <td>
		                	<textarea name="content" style="width:580px" rows="15"></textarea>
		                </td>
		            </tr>
		        </table>
		        <div class="buttons">
		        	<input type="submit" value="글쓰기" style="height:25px" />
		        	<input type="button" id="btnCancel" value="취소" style="height:25px" />
		        </div>
		        </form>
		    </div>
		</div>   	
	
	</div>
	</div>

	<script>
	window.addEventListener("load", function(event) { // 브라우저가 현재 화면을 모두 처리한 후 호출하는 함수 등록
		
		const btnCancel = document.querySelector("#btnCancel"); // id="btnCancel"인 요소 찾기
		btnCancel.addEventListener("click", function(event) {
			location.href = "list"; // 브라우저의 주소 입력기에 주소를 입력하는 것과 같은 효과 ( 이동 )
		});

	});
	</script>
	

</body>
</html>








