package com.springexample.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {

//	// 1. 요청 데이터 읽기 연습 - GET 방식 요청, HttpServletRequst 사용
//	@RequestMapping(path = { "/demo/param" }, method = { RequestMethod.GET })
//	public String processParams(HttpServletRequest req) {
//		
//		String data1 = req.getParameter("data1");
//		String sdata2 = req.getParameter("data2");
//		int data2 = Integer.parseInt(sdata2);
//		
//		System.out.printf("DATA1 : %s, DATA2 : %d\n", data1, data2);
//		
//		return "result"; // "/WEB-INF/views/" + result + ".jsp"
//	}
	
	// 2. 요청 데이터 읽기 연습 - GET 방식 요청, 처리된 변수 사용 ( 이름을 일치 시켜야 합니다. )
	// @RequestMapping(path = { "/demo/param" }, method = { RequestMethod.GET })
	@GetMapping(path = { "/demo/param" })
	public String processParams(String data1, int data2) {
		
		System.out.printf("DATA1 : %s, DATA2 : %d\n", data1, data2);
		
		return "result"; // "/WEB-INF/views/" + result + ".jsp"
	}
	
}






