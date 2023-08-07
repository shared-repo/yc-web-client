package com.demoweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoweb.dto.MemberDto;

// 서블릿 만들기
// 1. HttpServlet 상속
// 2. @WebServlet 매핑
// 3. doGet or doPost 구현

@WebServlet(urlPatterns = { "/account/register.action" } ) // 서버 코드에서는 절대 경로에 웹애플리케이션 이름 사용 X
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1. 요청 데이터 읽기 (여기서는 생략 - 데이터 없음)		
		//2. 요청 처리 (여기서는 생략 - 처리 내용 없음)
		//3. JSP에서 읽을 수 있도록 Request 객체에 데이터 저장 (생략)
		
		//4. 응답 컨텐츠 생상 ( JSP에서 처리 - forward로 이동)
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/account/register.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1-1. 요청 데이터 읽기 : req.getParameter("이름")
		req.setCharacterEncoding("utf-8");
		String memberId = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");
		String confirm = req.getParameter("confirm");
		String email = req.getParameter("email");
		
		// 1-2. MemberDto 객체에 요청 데이터 저장
		MemberDto member = new MemberDto();
		member.setMemberId(memberId);
		member.setPasswd(passwd);
		member.setEmail(email);
		member.setRegDate(new Date());
		
		// 2. 처리 (회원가입정보 저장)
		// System.out.printf("[%s][%s][%s][%s]\n", memberId, passwd, confirm, email);
		ServletContext application = req.getServletContext(); // jsp의 application 기본 객체와 같은 객체
		ArrayList<MemberDto> members = (ArrayList<MemberDto>)application.getAttribute("members");
		// members에 회원 데이터 저장하는 코드 작성
		members.add(member);

		// 3. 응답컨텐츠 생산 ( 여기서는 다른 작업 영역으로 redirect로 이동 )
//		resp.setContentType("text/html;charset=utf-8");
//		PrintWriter out = resp.getWriter();
//		out.printf("<h1>[%s][%s][%s][%s]</h1>", memberId, passwd, confirm, email);
		
		resp.sendRedirect("/demoweb/home.action"); // 이 주소는 브라우저가 사용하는 주소이므로 애플리케이션 이름 포함해야 합니다.
		
		
		
		
	}
}











