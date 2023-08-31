package com.demoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = { "/board" }) // 이 컨터롤러의 메서드에 적용될 공통 경로 설정
public class BoardController {
	
	@GetMapping(path = { "/list" })
	public String list() {
		
		return "board/list"; // "/WEB-INF/views/" + board/list + ".jsp"
	}
	
	@GetMapping(path = { "/write" })
	public String showWriteForm() {
		
		return "board/write"; // "/WEB-INF/views/" + board/write + ".jsp"
	}
}
