package com.demoweb.controller;

import com.demoweb.dao.AccountDao;
import com.demoweb.dto.HandleResultDto;
import com.demoweb.dto.MemberDto;

public class LoginController {

	public HandleResultDto handleRequest(String method, Object formData) {

		// 2. 요청 처리
		// 3. 처리 결과를 모델에 저장해서 반환
		if (method.equals("get")) {
			return new HandleResultDto(false, "account/login.jsp", null);
		} else {
			MemberDto member1 = (MemberDto)formData;
			AccountDao dao = new AccountDao();
			MemberDto member = dao.selectMemberByIdAndPasswd(member1.getMemberId(), member1.getPasswd());
			if (member != null) {
				return new HandleResultDto(true, "/demoweb/home.action", member);
			} else {
				return new HandleResultDto(false, "account/login.jsp", null);	
			}
		}
		
	}
	
}






