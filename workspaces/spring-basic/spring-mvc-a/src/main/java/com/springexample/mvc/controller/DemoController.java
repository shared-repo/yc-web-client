package com.springexample.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springexample.mvc.dto.Person;

@Controller
public class DemoController {

//	// 1. 요청 데이터 읽기 연습 - GET 방식 요청, HttpServletRequst 사용
//	@RequestMapping(path = { "/demo/param" }, method = { RequestMethod.GET })
//	public String processParams1(HttpServletRequest req) {
//		
//		String data1 = req.getParameter("data1");
//		String sdata2 = req.getParameter("data2");
//		int data2 = Integer.parseInt(sdata2);
//		
//		System.out.printf("DATA1 : %s, DATA2 : %d\n", data1, data2);
//		
//		return "result"; // "/WEB-INF/views/" + result + ".jsp"
//	}
	
//	// 2. 요청 데이터 읽기 연습 - GET 방식 요청, 처리된 변수 사용 ( 이름을 일치 시켜야 합니다. )
//	// @RequestMapping(path = { "/demo/param" }, method = { RequestMethod.GET })
//	@GetMapping(path = { "/demo/param" })
//	public String processParams2(String data1, int data2) {
//		
//		System.out.printf("DATA1 : %s, DATA2 : %d\n", data1, data2);
//		
//		return "result"; // "/WEB-INF/views/" + result + ".jsp"
//	}
	
	// 2. 요청 데이터 읽기 연습 - GET 방식 요청, 처리된 변수 사용 ( 이름이 다른 경우 @RequestParam으로 매핑 시켜야 합니다. )
	// @RequestMapping(path = { "/demo/param" }, method = { RequestMethod.GET })
	@GetMapping(path = { "/demo/param" })
	public String processParams2(@RequestParam(name="data1")String datax, @RequestParam(name="data2")int datay) {
		
		System.out.printf("DATA1 : %s, DATA2 : %d\n", datax, datay);
		
		return "result"; // "/WEB-INF/views/" + result + ".jsp"
	}
	
//	// 3. 요청 데이터 읽기 연습 - POST 방식 요청, 처리된 변수 사용 ( 이름을 일치 시켜야 합니다. )
//	// @RequestMapping(path = { "/demo/param" }, method = { RequestMethod.POST })
//	@PostMapping(path = { "/demo/param" })
//	public String processParams3(String name, String phone, String email, int age) {
//		
//		Person person = new Person();
//		person.setName(name);
//		person.setEmail(email);
//		person.setPhone(phone);
//		person.setAge(age);
//		
//		System.out.println(person);
//		
//		return "result"; // "/WEB-INF/views/" + result + ".jsp"
//	}
	
	// 4. 요청 데이터 읽기 연습 - POST 방식 요청, 처리된 DTO 객체 사용 ( 필드 이름을 일치 시켜야 합니다. )
	@PostMapping(path = { "/demo/param" })
	public String processParams4(Person person) {
		
		System.out.println(person);
		
		return "result"; // "/WEB-INF/views/" + result + ".jsp"
	}
	
}






