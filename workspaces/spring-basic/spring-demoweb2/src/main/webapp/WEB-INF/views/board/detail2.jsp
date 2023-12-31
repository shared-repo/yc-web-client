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
		        	[ <a href="list?pageNo=${ pageNo }">목록보기</a> ]
		        	<c:if test="${ not empty sessionScope.loginuser and loginuser.memberId eq board.writer }">
		        	[ <a href="edit?boardNo=${ board.boardNo }&pageNo=${ pageNo }">수정</a> ]
		        	[ <a href="javascript:" id="delete-board-lnk">삭제</a> ]
		        	</c:if>
		        </div>		        
		    </div>
		</div>
		
		<br><br>
		
		<!-- write comment area -->
		<form id="commentform" action="write-comment" method="post">
			<input type="hidden" name="boardNo" value="${ board.boardNo }" />
			<input type="hidden" name="pageNo" value="${ pageNo }" />
			<input type="hidden" name="writer" value="${ loginuser.memberId }" />
			<table style="width:800px;border:solid 1px;margin:0 auto">
				<tr>
					<td style="width:750px">	                	
						<textarea id="comment_content" name="content" style="width:100%;resize: none;" rows="3"></textarea>	                    
					</td>
					<td style="width:50px;vertical-align:middle">
						<a id="write-comment-lnk" href="javascript:" style="text-decoration:none">
							댓글<br />등록
						</a>
					</td>
				</tr>                    
			</table>
		</form>
		<!-- end of write comment area -->
	
		<!-- comment list area -->
		<br>
	    <hr style="width:800px;margin:0 auto">
	    <br>
	    <table id="comment-list" style="width:800px;border:solid 1px;margin:0 auto">
		<c:forEach var="comment" items="${ board.boardCommentList }">				
			<tr>
				<td style="text-align:left;margin:5px;border-bottom: solid 1px;">					
					<div id="comment-view-area-${ comment.commentNo }">
					<c:choose>
					<c:when test="${ comment.deleted }">
						<br><br>
						<span style='color:gray'>삭제된 글입니다.</span>
						<br><br>
					</c:when>
					<c:otherwise>
						${ comment.writer } &nbsp;&nbsp; [<fmt:formatDate value="${ comment.regDate }" pattern="yyyy-MM-dd hh:mm:ss"/>]
					    <br /><br />
					    <span>${ fn:replace(comment.content, enter, "<br>") }</span>
						<br /><br />
						<div style='display:${ (not empty loginuser and loginuser.memberId == comment.writer) ? "block" : "none" }'>
					    	<a class="edit-comment" data-comment-no="${ comment.commentNo }" href="javascript:">편집</a>
							&nbsp;
							<a class="delete-comment" data-comment-no="${ comment.commentNo }" href="javascript:">삭제</a>
						</div>
					</c:otherwise>
					</c:choose>
					</div>	                
					<div id="comment-edit-area-${ comment.commentNo }" style="display: none">
						${ comment.writer } &nbsp;&nbsp; [${ comment.regDate }]
						<br /><br />
						<form action="edit-comment" method="post">
						<input type="hidden" name="commentNo" value="${ comment.commentNo }" />
						<input type="hidden" name="boardNo" value="${ board.boardNo }" />
						<input type="hidden" name="pageNo" value="${ pageNo }" />
						<textarea name="content" style="width: 99%; resize: none" rows="3" maxlength="200">${ comment.content }</textarea>
						</form>
						<br />
						<div>
							<a class="update-comment" data-comment-no="${ comment.commentNo }" href="javascript:">수정</a> 
							&nbsp; 
							<a class="cancel-edit-comment" data-comment-no="${ comment.commentNo }" href="javascript:">취소</a>
						</div>
					</div>
			
				</td>
			</tr>
		</c:forEach>        	
		</table>
		<!-- end of comment list area -->
	
	</div>
	</div>
	
	
	<script>
	window.addEventListener('load', function(event) {
		
		const deleteBoardLnk = document.querySelector('#delete-board-lnk');
		if (deleteBoardLnk) {
			deleteBoardLnk.addEventListener('click', function(event) {
				const yes = confirm(${ board.boardNo } + "번 게시물을 삭제할까요?");
				if (yes) {
					location.href = 'delete/' + ${ board.boardNo } + "?pageNo=" + ${ pageNo };
				}
			});
		}
		
		// 댓글 쓰기 이벤트 처리
		const writeCommentLnk = document.querySelector("#write-comment-lnk");
		writeCommentLnk.addEventListener("click", function(event) {
			const commentForm = document.querySelector('#commentform');
			commentForm.submit(); // <input type="submit"을 클릭한 것과 같은 효과 --> form을 submit
		});
		
		// 댓글 삭제 이벤트 처리
		const deleteCommentLinks = document.querySelectorAll(".delete-comment");
		for (let i = 0; i < deleteCommentLinks.length; i++) {
			deleteCommentLinks[i].addEventListener('click', function(event) {
				// alert('delete comment');
				const currentDeleteLink = event.target; // 현재 이벤트를 발생시킨 요소
				const commentNo = currentDeleteLink.getAttribute("data-comment-no");
				
				const yn = confirm(commentNo + "번 댓글을 삭제할까요?");
				if (yn) {
					location.href = 'delete-comment?commentNo=' + commentNo + 
												  '&boardNo=' + ${ board.boardNo } + 
												  '&pageNo=' + ${ pageNo };
				}
			});
		}
		
		let currentEditCommentNo = null;
		
		// 편집 링크 클릭 이벤트 처리
		const editCommentLinks = document.querySelectorAll(".edit-comment");
		for (let i = 0; i < editCommentLinks.length; i++) {
			editCommentLinks[i].addEventListener('click', function(event) {
				const currentEditLink = event.target;
				const commentNo = currentEditLink.getAttribute("data-comment-no");
				
				const editDiv = document.querySelector('#comment-edit-area-' + commentNo);
				const viewDiv = document.querySelector('#comment-view-area-' + commentNo);
				
				editDiv.style['display'] = '';
				viewDiv.style['display'] = 'none';
				if (currentEditCommentNo) { // 이전에 편집하던 요소의 표시 상태 변경 (복원)
					document.querySelector('#comment-edit-area-' + currentEditCommentNo).style['display'] = 'none';
					document.querySelector('#comment-view-area-' + currentEditCommentNo).style['display'] = '';
				}
				currentEditCommentNo = commentNo;
				
			}); // end of addEventListener
		} // end of for
		
		// 편집 취소 링크 클릭 이벤트 처리
		const cancelEditCommentLinks = document.querySelectorAll(".cancel-edit-comment");
		for (let i = 0; i < cancelEditCommentLinks.length; i++) {
			cancelEditCommentLinks[i].addEventListener('click', function(event) {
				const currentCancelEditLink = event.target;
				const commentNo = currentCancelEditLink.getAttribute("data-comment-no");
				
				const editDiv = document.querySelector('#comment-edit-area-' + commentNo);
				const viewDiv = document.querySelector('#comment-view-area-' + commentNo);
				
				editDiv.style['display'] = 'none';
				viewDiv.style['display'] = '';
				currentEditCommentNo = null;
				
			}); // end of addEventListener
		} // end of for
		
		// 댓글 수정 이벤트 처리
		const updateCommentLinks = document.querySelectorAll(".update-comment");
		for (let i = 0; i < updateCommentLinks.length; i++) {
			updateCommentLinks[i].addEventListener('click', function(event) {

				const currentUpdateLink = event.target; // 현재 이벤트를 발생시킨 요소
				const commentNo = currentUpdateLink.getAttribute("data-comment-no");
				
							 // <div id='comment-edit-area-commentNo'>의 하위 <form> 찾기
				const form = document.querySelector('#comment-edit-area-' + commentNo + ' form')
				form.submit();
			});
		}
		
		
	})
	</script>

</body>
</html>








