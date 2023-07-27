<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>

		<% String bgColor=request.getParameter("bgColor"); %>
		<% if (bgColor != null && !bgColor.equals("")) { %>
		<div id="header" 
			 style="background-color:<%= bgColor %>"> 
		<% } else { %>
		<div id="header">
		<% }  %>
		   	
            <div class="title">
                <a href="#">DEMO WEBSITE</a>
            </div>
            <div class="links">
            	<!-- <a href="#">로그인</a> -->
            	<a href="/demoweb/account/login.action">로그인</a>
                <!-- <a href="account/register.jsp">회원가입</a> -->
                <!-- <a href="/demoweb/account/register.jsp">회원가입</a> --> <!-- 절대경로 사용 -->
                <a href="/demoweb/account/register.action">회원가입</a>
            </div>
        </div>
                
        <div id="menu">
            <div>
                <ul>
                    <li><a href="#">사용자관리</a></li>
					<li><a href="#">메일보내기</a></li>
					<li><a href="#">자료실</a></li>
					<li><a href="#">게시판</a></li>
                </ul>
            </div>
		</div>