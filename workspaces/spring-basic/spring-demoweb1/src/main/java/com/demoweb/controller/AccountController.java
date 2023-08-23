package com.demoweb.controller;

import org.springframework.stereotype.Controller;
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
}
