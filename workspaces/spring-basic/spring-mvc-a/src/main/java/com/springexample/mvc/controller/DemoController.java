package com.springexample.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
//	// 2. 요청 데이터 읽기 연습 - GET 방식 요청, 처리된 변수 사용 ( 이름이 다른 경우 @RequestParam으로 매핑 시켜야 합니다. )
//	@GetMapping(path = { "/demo/param" })
//	public String processParams2(@RequestParam(name="data1")String datax, @RequestParam(name="data2")int datay) {
//		
//		System.out.printf("DATA1 : %s, DATA2 : %d\n", datax, datay);
//		
//		return "result"; // "/WEB-INF/views/" + result + ".jsp"
//	}
	
	// 2. 요청 데이터 읽기 연습 - GET 방식 요청, 처리된 변수 사용 ( 요청 데이터에 없는 primitive 타입 전달인자 사용 - 오류 )
	@GetMapping(path = { "/demo/param" })
	// public String processParams2(String data1, int data2, String data3, int data4) {
	public String processParams2(String data1, int data2, 
								 String data3, 
								 @RequestParam(defaultValue = "0") int data4,
								 Model model) { // Model 타입 전달인자는 View로 데이터를 전달하는 통로
		
		System.out.printf("DATA1 : %s, DATA2 : %d, DATA4 : %d\n", data1, data2, data4);
		
		model.addAttribute("data1", data1); // model 객체에 데이터를 저장하면 View에서 읽을 수 있습니다.
		model.addAttribute("data2", data2);
		
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
		
		System.out.println(person); // person.toString()
		
		return "result"; // "/WEB-INF/views/" + result + ".jsp"
	}
	
	// 5. 요청 데이터 읽기 연습 - GET 방식 요청, 처리된 변수 사용 ( 요청 데이터에 없는 primitive 타입 전달인자 사용 - 오류 )
	@GetMapping(path = { "/demo/param2/{name}/{age}" }) // {name}, {age} : 경로를 통해 전달되는 데이터 표시
	public String processParams5(@PathVariable String name, @PathVariable int age) {
		
		System.out.printf("NAME : %s, AGE : %d\n", name, age);
		
		return "result"; // "/WEB-INF/views/" + result + ".jsp"
	}
	
}






