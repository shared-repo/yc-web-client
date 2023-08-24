package com.demoweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demoweb.dao.AccountDao;
import com.demoweb.dto.MemberDto;

@Controller
@RequestMapping(path = { "/account" })
public class AccountController {

	@GetMapping(path = { "/register" })
	public String registerForm() {
		
		return "account/register"; // "/WEB-INF/views/" + account/register + ".jsp"
	}
	
	@PostMapping(path = { "/register" })
	public String register(MemberDto member) {
		
		AccountDao dao = new AccountDao();
		dao.insertMember(member);
		
		return "redirect:/home";
	}
	
	@GetMapping(path = { "/login" })
	public String loginForm() {
		
		return "account/login"; // "/WEB-INF/views/" + account/login + ".jsp"
	}
	
	@PostMapping(path = { "/login" })
	// public String login(String memberId, String passwd) {
	public String login(MemberDto member, HttpSession session, Model model) {
		
		AccountDao dao = new AccountDao();
		MemberDto member2 = dao.selectMemberByIdAndPasswd(member.getMemberId(), member.getPasswd());
		
		if (member2 != null) { // 로그인 가능 : 사용자가 입력한 id와 passwd에 해당하는 사용자가 존재
			session.setAttribute("loginuser", member2);
			return "redirect:/home";
		} else {
			model.addAttribute("loginfail", true); // Model 타입 전달인자에 데이터를 저장하면 View에서 읽을 수 있습니다.
			return "account/login";
		}
		
	}
}








