package com.demoweb.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demoweb.dto.MemberDto;

@WebServlet(urlPatterns = { "/account/login.action" })
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1. 요청 데이터 읽기
		// 2. 요청 처리
		// 3. JSP에게 전달할 데이터를 request객체에 저장
		// 4. JSP로 이동
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/account/login.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청 데이터 읽기
		req.setCharacterEncoding("utf-8");
		String memberId = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");
		
		// 2. 요청 처리 ( 로그인 처리 )
		// System.out.printf("[%s][%s]\n", memberId, passwd); // 테스트 코드
		// 저장된 회원가입정보에서 사용자 정보 조회 및 로그인 결정
		ServletContext application = req.getServletContext();
		ArrayList<MemberDto> members =  (ArrayList<MemberDto>)application.getAttribute("members");
		for (MemberDto member : members) {
			if (memberId.equals(member.getMemberId()) && passwd.equals(member.getPasswd())) { // 로그인 성공
				// 로그인 처리 - 세션에 로그인 정보 저장
				HttpSession session = req.getSession(); // 요청 객체로부터 세션 객체 가져오기
				session.setAttribute("loginuser", memberId); // 세션에 데이터 저장
				
				// 4. 일련의 작업이 끝났으면 redirect로 이동
				resp.sendRedirect("/demoweb/home.action"); // sendRedirect는 메서드를 종료하지 않습니다.
				return; // 메서드 종료
			}
		}
		
		// 3. JSP에게 전달할 데이터를 request객체에 저장
		req.setAttribute("loginfail", true);
		doGet(req, resp); // 다시 로그인 페이지로 forward 이동
	}
}






