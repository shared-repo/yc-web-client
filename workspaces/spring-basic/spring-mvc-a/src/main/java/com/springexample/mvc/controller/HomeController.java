package com.springexample.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Spring IoC Container에 컨트롤러로 등록
public class HomeController {
	
	@RequestMapping(path = { "/", "/home" })
	public String home() {
		
		return "home"; // "home.jsp"로 해석
	}

}
