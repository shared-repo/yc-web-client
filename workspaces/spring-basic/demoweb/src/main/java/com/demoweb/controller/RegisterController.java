package com.demoweb.controller;

import com.demoweb.dao.AccountDao;
import com.demoweb.dto.HandleResultDto;
import com.demoweb.dto.MemberDto;

public class RegisterController {

	public HandleResultDto handleRequest(String method, Object formData) {
	
		// 2. 요청 처리
		// 3. 처리 결과를 모델에 저장해서 반환
		if (method.equals("get")) {
			return new HandleResultDto(false, "account/register.jsp", null);
		} else {
			AccountDao dao = new AccountDao();
			MemberDto member = (MemberDto)formData;
			dao.insertMember(member);
			
			return new HandleResultDto(true, "/demoweb/home.action", null);
		}
		
	}
	
}











