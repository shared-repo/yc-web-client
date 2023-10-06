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
						<div style='float:left; display:${ (not empty loginuser and loginuser.memberId == comment.writer) ? "block" : "none" }'>
					    	<a class="edit-comment" data-comment-no="${ comment.commentNo }" href="javascript:">편집</a>
							&nbsp;
							<a class="delete-comment" data-comment-no="${ comment.commentNo }" href="javascript:">삭제</a>
							&nbsp;&nbsp;
						</div>
						<div style='float:left; display:${ not empty loginuser ? "block" : "none" }'>
							<a class="write-recomment" data-comment-no="${ comment.commentNo }" href="javascript:">댓글쓰기</a>
						</div>
						<span style="clear:both"></span>
					</c:otherwise>
					</c:choose>
					</div>	                
					<div id="comment-edit-area-${ comment.commentNo }" style="display: none">
						${ comment.writer } &nbsp;&nbsp; [${ comment.regDate }]
						<br /><br />
						<form action="edit-comment" method="post">
						<input type="hidden" name="commentNo" value="${ comment.commentNo }" />
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
	
	<!-- Modal -->
	<div class="modal fade" id="recomment-modal" tabindex="-1" aria-labelledby="recomment-modal-label" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h1 class="modal-title fs-5" id="recomment-modal-label">댓글 쓰기</h1>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <form id="recommentform" action="write-recomment" method="post">
				<input type="hidden" name="commentNo" value="" />
				<input type="hidden" name="writer" value="${ loginuser.memberId }" />
				
				<textarea id="recomment_content" name="content" class="form-control" style="resize: none;" rows="3"></textarea>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
	        <button type="button" class="btn btn-primary">댓글 쓰기</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- 자사 웹서버에서 jquery js 파일 배포 -->
	<script src="/spring-demoweb/resources/js/jquery-3.7.1.js"></script>
	
	<!-- CDN 서버에서 jquery js 파일 배포 -->
	<!-- <script src="https://code.jquery.com/jquery-3.7.1.js"></script> -->
	
	<script>
	$(function(event) {
		
		$('#delete-board-lnk').on('click', function(event) {
			const yes = confirm(${ board.boardNo } + "번 게시물을 삭제할까요?");
			if (yes) {
				location.href = 'delete/' + ${ board.boardNo } + "?pageNo=" + ${ pageNo };
			}
		});
		
		/////////////////////////////////////////////////////////////////////////
		
		
		
		// 댓글 쓰기 이벤트 처리
		$("#write-comment-lnk").on("click", function(event) {
			// $('#commentform').submit(); // <input type="submit"을 클릭한 것과 같은 효과 --> form을 submit
			
			const formData = $('#commentform').serialize(); // serialize : form의 데이터만 뽑는 함수
			// alert(formData);
			$.ajax({
				"url": "ajax-write-comment",
				"method": "post",
				"data": formData,
				"success": function(data, status, xhr) {
					// alert(data);
					// 댓글 목록 영역 업데이트 ( 부분 화면 갱신 )
					$('#comment-list').load('comment-list?boardNo=${board.boardNo}'); // load : ajax 방식으로 서버에 요청을 보내고 수신한 html을 사용해서 화면의 일부를 갱신하는 함수
				},
				"error": function(xhr, status, err) {
					alert("fail");
				}
			});
		});
		
		// 댓글 삭제 이벤트 처리
		// $(".delete-comment").on('click', function(event) {
		$("#comment-list").on('click', ".delete-comment", function(event) {
			const commentNo = $(this).attr("data-comment-no");			
			const yn = confirm(commentNo + "번 댓글을 삭제할까요?");
			if (yn) {
				$.ajax({
					"url": "ajax-delete-comment",
					"method": "get",
					"data": "commentNo=" + commentNo,
					"success": function(data, status, xhr) {
						$('#comment-list').load('comment-list?boardNo=${board.boardNo}');
						currentEditCommentNo = null;
					},
					"error": function(xhr, status, err) {
						alert("댓글 삭제 실패");
					}
				});
			}
		});

		
		let currentEditCommentNo = null;
		
		// 편집 링크 클릭 이벤트 처리
		// $(".edit-comment").on('click', function(event) {
		$("#comment-list").on('click', ".edit-comment", function(event) {
			const commentNo = $(this).attr("data-comment-no");
			
			$('#comment-edit-area-' + commentNo).css('display', '');
			$('#comment-view-area-' + commentNo).css('display', 'none');
			
			if (currentEditCommentNo) { // 이전에 편집하던 요소의 표시 상태 변경 (복원)
				$('#comment-edit-area-' + currentEditCommentNo).css('display', 'none');
				$('#comment-view-area-' + currentEditCommentNo).css('display', '');
			}
			currentEditCommentNo = commentNo;
			
		}); // end of addEventListener

		
		// 편집 취소 링크 클릭 이벤트 처리
		// $(".cancel-edit-comment").on('click', function(event) {
		$('#comment-list').on('click', ".cancel-edit-comment", function(event) {
			const commentNo = $(this).attr("data-comment-no");
			
			$('#comment-edit-area-' + commentNo).css('display', 'none');
			$('#comment-view-area-' + commentNo).css('display', '');
			
			currentEditCommentNo = null;
			
		}); // end of addEventListener
		
		// 댓글 수정 이벤트 처리
		// $(".update-comment").click(function(event) {
		$("#comment-list").on("click", ".update-comment", function(event) {
			// const commentNo = $(this).attr("data-comment-no");
			const commentNo = $(this).data('comment-no'); // data-속성이름="값" 으로 표현된 속성의 값 읽기
			
			// $('#comment-edit-area-' + commentNo + ' form').submit();
			const formData = $('#comment-edit-area-' + commentNo + ' form').serialize();
			$.ajax({
				"url": "ajax-edit-comment",
				"method": "post",
				"data": formData,
				"success": function(data, status, xhr) {
					$('#comment-list').load('comment-list?boardNo=${board.boardNo}');
					currentEditCommentNo = null;
				},
				"error": function(xhr, status, err) {
					alert('댓글 수정 실패')
				}
			});
			
		});
		
		$("#comment-list").on("click", ".write-recomment", function(event) {
			const commentNo = $(this).data('comment-no');
			
		});
		
	})
	</script>

</body>
</html>








