package com.exampleweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/register" })
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset='utf-8' />");
		out.println("	<title>Register</title>");
		out.println("	<link rel='Stylesheet' href='/demoweb/styles/default.css' />");
		out.println("	<link rel='Stylesheet' href='/demoweb/styles/input.css' />");
		out.println("</head>");
		out.println("<body>");

		out.println("	<div id='pageContainer'>");
		
		out.println("		<div id='header'>");
		out.println("            <div class='title'>");
		out.println("                <a href='#'>DEMO WEBSITE</a>");
		out.println("            </div>");
		out.println("            <div class='links'>");
		out.println("            	<a href='#'>로그인</a>");
		out.println("                <a href='#'>회원가입</a>");
		out.println("            </div>");
		out.println("        </div>");
		                
		out.println("        <div id='menu'>");
		out.println("            <div>");
		out.println("                <ul>");
		out.println("                    <li><a href='#'>사용자관리</a></li>");
		out.println("					<li><a href='#'>메일보내기</a></li>");
		out.println("					<li><a href='#'>자료실</a></li>");
		out.println("					<li><a href='#'>게시판</a></li>");
		out.println("                </ul>");
		out.println("            </div>");
		out.println("		</div>");
				
		out.println("		<div id='inputcontent'>");
		out.println("			<br /><br />");
		out.println("		    <div id='inputmain'>");
		out.println("		        <div class='inputsubtitle'>회원기본정보</div>");
		out.println("				<form id='registerform' action='register.action' method='post'>");
		out.println("		        <table>");
		out.println("		            <tr>");
		out.println("		                <th>아이디(ID)</th>");
		out.println("		                <td>");
		out.println("		                    <input type='text' style='width:280px' />");
		out.println("		                </td>");
		out.println("		            </tr>");
		out.println("		            <tr>");
		out.println("		                <th>비밀번호</th>");
		out.println("		                <td>");
		out.println("		                	<input type='password' style='width:280px' />");
		out.println("		                </td>");
		out.println("		            </tr>");
		out.println("		            <tr>");
		out.println("		                <th>비밀번호 확인</th>");
		out.println("		                <td>");
		out.println("		                    <input type='password' style='width:280px' />");
		out.println("		                </td>");
		out.println("		            </tr>");
		out.println("		            <tr>");
		out.println("		                <th>이메일</th>");
		out.println("		                <td>");
		out.println("		                	<input type='text' style='width:280px' />");
		out.println("		                </td>");
		out.println("		            </tr>");
				                       		            
		out.println("		        </table>");
		out.println("		        <div class='buttons'>");
		out.println("		        	<input id='register' type='submit' value='등록' style='height:25px' />");
		out.println("		        	<input id='cancel' type='button' value='취소' style='height:25px'  />");

		out.println("		        </div>");
		out.println("		        </form>");
		out.println("		    </div>");
		out.println("		</div>");
		out.println("	</div>");

		out.println("</body>");
		out.println("</html>");



		
	}
	
}
