<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset='utf-8' />
	<title>Register</title>
	<link rel='Stylesheet' href='/demowebsup/styles/default.css' />
	<link rel='Stylesheet' href='/demowebsup/styles/input.css' />
</head>
<body>

	<div id='pageContainer'>

		<jsp:include page="/WEB-INF/views/modules/header.jsp" />
		
		<div id="inputcontent">
			<br /><br />
		    <div id="inputmain">
		        <div class="inputsubtitle">회원기본정보</div>
		        <!-- <form id="registerform" action="/demowebsup/account/register.action" method="post"> -->
				<form id="registerform" action="register.action" method="post">
		        <table>
		            <tr>
		                <th>아이디(ID)</th>
		                <td>
		                    <input type="text" style="width:280px" name="memberId" />
		                </td>
		            </tr>
		            <tr>
		                <th>비밀번호</th>
		                <td>
		                	<input type="password" style="width:280px" name="passwd" />
		                </td>
		            </tr>
		            <tr>
		                <th>비밀번호 확인</th>
		                <td>
		                    <input type="password" style="width:280px" name="confirm"/>
		                </td>
		            </tr>
		            <tr>
		                <th>이메일</th>
		                <td>
		                	<input type="text" style="width:280px" name="email" />
		                </td>
		            </tr>
		                       		            
		        </table>
		        <div class="buttons">
		        	<input id="register" type="submit" value="등록" style="height:25px" />
		        	<input id="cancel" type="button" value="취소" style="height:25px"  />

		        </div>
		        </form>
		    </div>
		</div>   	
	</div>

</body>
</html>


