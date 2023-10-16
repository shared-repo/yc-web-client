<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset='utf-8' />
	<title>Login</title>
	<link rel='Stylesheet' href='/spring-demoweb/resources/styles/default.css' />
	<link rel='Stylesheet' href='/spring-demoweb/resources/styles/input.css' />
</head>
<body>

	<div id='pageContainer'>
		
		<jsp:include page="/WEB-INF/views/modules/header.jsp" />		
		
		<div id="inputcontent">
			<br /><br />
		    <div id="inputmain">
		        <div class="inputsubtitle">로그인정보</div>
		        
		        <form action="login" method="post">
		        <input type="hidden" name="returnUrl" value="${ returnUrl }">
		        <table>
		            <tr>
		                <th>아이디(ID)</th>
		                <td>
		                    <input type="text" name="memberId" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>비밀번호</th>
		                <td>
		                	<input type="password" name="passwd" style="width:280px" />
		                </td>
		            </tr>
		        </table>
		        
		        <div class="buttons">
		        	<input type="submit" value="로그인" style="height:25px" />
		        	<input type="button" value="취소" style="height:25px" />
		        </div>
		        </form>
		        
		    </div>
		</div>  	
	</div>
	
	<script>
		<% Boolean loginFail = (Boolean)request.getAttribute("loginfail"); %>
		<% if ( loginFail != null && loginFail == true ) { %>
			alert("로그인 실패 : 아이디 또는 패스워드가 일치하지 않습니다.");
		<% } %>
	</script>

</body>
</html>


