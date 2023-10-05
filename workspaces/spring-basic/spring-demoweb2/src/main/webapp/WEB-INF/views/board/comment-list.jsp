<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

		<c:forEach var="comment" items="${ comments }"> <%-- for (BoardComment comment : comments) --%>				
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
		






