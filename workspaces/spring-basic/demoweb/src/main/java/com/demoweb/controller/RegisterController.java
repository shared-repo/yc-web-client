package com.demoweb.controller;

public class RegisterController {

	public String handleRequest() {
	
		// 1. 요청 데이터 읽기
		// 2. 요청 처리
		// 3. 처리 결과를 모델에 저장해서 반환
		return "account/register.jsp";
		
	}
	
	protected void doPost() {
		
//		// 1-1. 요청 데이터 읽기 : req.getParameter("이름")
//		req.setCharacterEncoding("utf-8");
//		String memberId = req.getParameter("memberId");
//		String passwd = req.getParameter("passwd");
//		String confirm = req.getParameter("confirm");
//		String email = req.getParameter("email");
//		
//		// 1-2. MemberDto 객체에 요청 데이터 저장
//		MemberDto member = new MemberDto();
//		member.setMemberId(memberId);
//		member.setPasswd(passwd);
//		member.setEmail(email);
//		member.setRegDate(new Date());
//		
//		// 2. 처리 (회원가입정보 저장 - Dao 클래스 활용)
//		AccountDao dao = new AccountDao();
//		dao.insertMember(member);
//
//		// 3. 응답컨텐츠 생산 ( 여기서는 다른 작업 영역으로 redirect로 이동 )
////		resp.setContentType("text/html;charset=utf-8");
////		PrintWriter out = resp.getWriter();
////		out.printf("<h1>[%s][%s][%s][%s]</h1>", memberId, passwd, confirm, email);
//		
//		resp.sendRedirect("/demoweb/home.action"); // 이 주소는 브라우저가 사용하는 주소이므로 애플리케이션 이름 포함해야 합니다.
//		
//		
		
		
	}
}











