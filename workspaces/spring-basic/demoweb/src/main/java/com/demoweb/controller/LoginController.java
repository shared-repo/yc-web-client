package com.demoweb.controller;

import com.demoweb.dto.HandleResultDto;

public class LoginController {

	public HandleResultDto handleRequest(String method, Object formData) {

		// 2. 요청 처리
		// 3. 처리 결과를 모델에 저장해서 반환
		if (method.equals("get")) {
			return new HandleResultDto(false, "account/login.jsp", null);
		} else {
			return new HandleResultDto(false, "account/login.jsp", null);
		}
		
	}
	
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// 1. 요청 데이터 읽기
//		req.setCharacterEncoding("utf-8");
//		String memberId = req.getParameter("memberId");
//		String passwd = req.getParameter("passwd");
//		
//		// 2. 요청 처리 ( 로그인 처리 )
//		// System.out.printf("[%s][%s]\n", memberId, passwd); // 테스트 코드
//		// 저장된 회원가입정보에서 사용자 정보 조회 및 로그인 결정
//		AccountDao dao = new AccountDao();
//		MemberDto member = dao.selectMemberByIdAndPasswd(memberId, passwd);
//			
//		if (member != null) { // 로그인 성공
//			// 로그인 처리 - 세션에 로그인 정보 저장
//			HttpSession session = req.getSession(); // 요청 객체로부터 세션 객체 가져오기
//			session.setAttribute("loginuser", memberId); // 세션에 데이터 저장
//			
//			// 4. 일련의 작업이 끝났으면 redirect로 이동
//			resp.sendRedirect("/demoweb/home.action"); // sendRedirect는 메서드를 종료하지 않습니다.
//			return; // 메서드 종료
//		}
//		
//		// 3. JSP에게 전달할 데이터를 request객체에 저장
//		req.setAttribute("loginfail", true);
//		doGet(req, resp); // 다시 로그인 페이지로 forward 이동
//	}
}






