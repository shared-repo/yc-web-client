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
            	<% String loginUser = (String)session.getAttribute("loginuser"); %>
            	<% if (loginUser == null) { %> <%-- 로그인 여부 확인 (세션에 저장된 정보 확인) --%>
            	<a href="/demoweb/account/login.action">로그인</a>
                <a href="/demoweb/account/register.action">회원가입</a>
                <% } else { %>
                <%= loginUser %>님 환영합니다.
                <a href="/demoweb/account/logout.action">로그아웃</a>
                <% } %>
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