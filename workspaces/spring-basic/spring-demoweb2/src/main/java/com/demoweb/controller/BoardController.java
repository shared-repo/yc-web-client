package com.demoweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demoweb.dto.BoardDto;
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
	public String write(HttpSession session, BoardDto board) {
		
		if (session.getAttribute("loginuser") == null) { // 로그인 하지 않은 사용자
			return "redirect:/account/login";
		}
		
		// 1. 요청 데이터 읽기 ( 전달인자에서 자동 처리 )
		System.out.println(board);
		// 2. 요청 처리 ( 서비스 객체 호출 )
		// 3. JSP에서 읽을 수 있도록 데이터 저장 (선택적 - 여기서는 없음)
		// 4. View(jsp) 또는 다른 controller로 이동
		return "redirect:list";
	}
}







