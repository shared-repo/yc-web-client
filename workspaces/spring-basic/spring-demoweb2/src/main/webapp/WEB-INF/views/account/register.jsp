<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
	<meta charset='utf-8' />
	<title>Register</title>
	<link rel='Stylesheet' href='/spring-demoweb/resources/styles/default.css' />
	<link rel='Stylesheet' href='/spring-demoweb/resources/styles/input.css' />
	<style type="text/css">
		.error {
			color: red;
			font-weight: bold;
		}
	</style>
</head>
<body>

	<div id='pageContainer'>

		<jsp:include page="/WEB-INF/views/modules/header.jsp" />
		
		<div id="inputcontent">
			<br /><br />
		    <div id="inputmain">
		        <div class="inputsubtitle">회원기본정보</div>
		        <!-- form:form은 반드시 controlloler에서 전달한 객체에 바인딩되어야 합니다. -->
				<form:form id="registerform" action="register" method="post" modelAttribute="member">
		        <table>
		            <tr>
		                <th>아이디(ID)</th>
		                <td>
		                    <form:input style="width:300px" path="memberId" />
		                    <form:errors path="memberId" cssClass="error" />
		                </td>
		            </tr>
		            <tr>
		                <th>비밀번호</th>
		                <td>
		                	<form:password path="passwd" style="width:300px" />
		                	<form:errors path="passwd" cssClass="error" />
		                </td>
		            </tr>
		            <tr>
		                <th>비밀번호 확인</th>
		                <td>
		                    <input type="password" name="confirm" style="width:300px" />
		                </td>
		            </tr>
		            <tr>
		                <th>이메일</th>
		                <td>
		                	<form:input path="email" style="width:300px" />
		                	<form:errors path="email" cssClass="error" />
		                </td>
		            </tr>
		                       		            
		        </table>
		        <div class="buttons">
		        	<input id="register" type="submit" value="등록" style="height:25px" />
		        	<input id="cancel" type="button" value="취소" style="height:25px"  />
		        </div>
		        </form:form>
		    </div>
		</div>   	
	</div>

</body>
</html>


