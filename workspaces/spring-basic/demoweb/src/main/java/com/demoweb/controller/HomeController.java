package com.demoweb.controller;

import com.demoweb.dto.HandleResultDto;

public class HomeController {
	
	public HandleResultDto handleRequest(String method, Object formData) {

		// 2. 요청 처리
		// 3. 처리 결과를 모델에 저장해서 반환
		return new HandleResultDto(false, "home.jsp", null);
		
	}
	
}






