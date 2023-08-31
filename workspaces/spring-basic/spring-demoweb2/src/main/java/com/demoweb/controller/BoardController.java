package com.demoweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demoweb.dto.MemberDto;

@Controller
@RequestMapping(path = { "/board" }) // 이 컨터롤러의 메서드에 적용될 공통 경로 설정
public class BoardController {
	
	@GetMapping(path = { "/list" })
	public String list() {
		
		return "board/list"; // "/WEB-INF/views/" + board/list + ".jsp"
	}
	
	@GetMapping(path = { "/write" })
	public String showWriteForm(HttpSession session) {
		
		if (session.getAttribute("loginuser") == null) { // 로그인 하지 않은 사용자
			return "redirect:/account/login";
		}
		
		return "board/write"; // "/WEB-INF/views/" + board/write + ".jsp"
	}
	
	@PostMapping(path = { "/write" })
	public String write() {
		
		return "redirect:list";
	}
}







