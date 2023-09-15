package com.demoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/bootstrap")
	public String bootstrap() {
		return "bootstrap";
	}
	
}
