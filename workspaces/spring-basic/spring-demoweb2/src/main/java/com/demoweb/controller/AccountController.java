package com.demoweb.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demoweb.dao.JdbcAccountDao;
import com.demoweb.dto.MemberDto;
import com.demoweb.service.AccountService;
import com.demoweb.service.AccountServiceImpl;


@Controller
@RequestMapping(path = { "/account" })
public class AccountController {
	
	private AccountService accountService;
	
	@Autowired
	@Qualifier("accountService")
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping(path = { "/register" })
	public String registerForm(@ModelAttribute("member") MemberDto member) {
		
		return "account/register"; // "/WEB-INF/views/" + account/register + ".jsp"
	}
	
	@PostMapping(path = { "/register" })
	public String register(@ModelAttribute("member") @Valid MemberDto member, BindingResult result) {
		
		if (result.hasErrors()) {
			return "account/register";
		}
		
		// AccountService accountService = new AccountServiceImpl();
		accountService.register(member);
		
		return "redirect:/home";
	}
	
	@GetMapping(path = { "/login" })
	public String loginForm() {
		
		return "account/login"; // "/WEB-INF/views/" + account/login + ".jsp"
	}
	
	@PostMapping(path = { "/login" })
	// public String login(String memberId, String passwd) {
	public String login(MemberDto member, HttpSession session, Model model) {
		
		// AccountService accountService = new AccountServiceImpl();
		MemberDto loginMember = accountService.findLoginMember(member);
		
		if (loginMember != null) { // 로그인 가능 : 사용자가 입력한 id와 passwd에 해당하는 사용자가 존재
			session.setAttribute("loginuser", loginMember);
			return "redirect:/home";
		} else {
			model.addAttribute("loginfail", true); // Model 타입 전달인자에 데이터를 저장하면 View에서 읽을 수 있습니다.
			return "account/login";
		}
		
	}
	
	@GetMapping(path = { "/logout" })
	public String logout(HttpSession session) {
		
		// session.invalidate();
		session.removeAttribute("loginuser");
		
		return "redirect:/home";
	}
	
	@GetMapping(path = { "/check-id-dup" }, produces = "text/plain;charset=utf-8")
	@ResponseBody // 이 메서드가 반환하는 값은 view 이름이 아니고 응답컨텐츠입니다.
	public String checkMemberIdDuplication(String memberId) {
		
		return "사용가능한 아이디"; // 
	}
}








