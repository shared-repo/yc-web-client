<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>


<!DOCTYPE html>

<html>
<head>
	<meta charset='utf-8' />
	<title>Home</title>
	<link rel='Stylesheet' href='/demoweb/styles/default.css' />
</head>
<body>

	<div id='pageContainer'>
		
		<div id="header">    	
            <div class="title">
                <a href="#">DEMO WEBSITE</a>
            </div>
            <div class="links">
            	<a href="#">로그인</a>
                <!-- <a href="account/register.jsp">회원가입</a> -->
                <a href="/demoweb/account/register.jsp">회원가입</a> <!-- 절대경로 사용 -->
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
		
		<div id='content'>
			<br /><br /><br />
			<h2 style='text-align:center'>Welcome to Demo WebSite !!!</h2>
		</div>
	</div>

</body>
</html>


