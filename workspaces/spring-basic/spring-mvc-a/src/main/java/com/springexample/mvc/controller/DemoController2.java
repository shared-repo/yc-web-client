package com.springexample.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.springexample.mvc.dto.Person;
import com.springexample.mvc.view.MyView;

@Controller
@RequestMapping(path = { "/demo2" })
public class DemoController2 {

	@GetMapping(path = { "/param" })
	public String processParams2(String data1, int data2, 
								 String data3, 
								 @RequestParam(defaultValue = "0") int data4,
								 Model model) { // Model 타입 전달인자는 View로 데이터를 전달하는 통로
		
		System.out.printf("DATA1 : %s, DATA2 : %d, DATA4 : %d\n", data1, data2, data4);
		
		model.addAttribute("data1", data1); // model 객체에 데이터를 저장하면 View에서 읽을 수 있습니다.
		model.addAttribute("data2", data2);
		model.addAttribute("data3", data3);
		
		return "result"; // "/WEB-INF/views/" + result + ".jsp"
	}

	@PostMapping(path = { "/param" })
	public String processParams4Post(@ModelAttribute Person person, // @ModelAttribute 지정된 객체는 자동으로 View로 전달
								 Model model) { 
		
		System.out.println(person); // person.toString()		
		model.addAttribute("person2", person);
		
		return "result"; // "/WEB-INF/views/" + result + ".jsp"
	}
	@GetMapping(path = { "/param3" })
	public String processParams4Get(@ModelAttribute Person person, // @ModelAttribute 지정된 객체는 자동으로 View로 전달
								 Model model) { 
		
		System.out.println(person); // person.toString()		
		model.addAttribute("person2", person);
		
		return "result"; // "/WEB-INF/views/" + result + ".jsp"
	}
	
	@GetMapping(path = { "/param2/{name}/{age}" }) // {name}, {age} : 경로를 통해 전달되는 데이터 표시
	public ModelAndView processParams5(@PathVariable String name, @PathVariable int age) {
		
		System.out.printf("NAME : %s, AGE : %d\n", name, age);
		
		ModelAndView mav = new ModelAndView(); // View와 View로 전송할 데이터 저장하는 객체
		mav.setViewName("result"); // "/WEB-INF/views/" + result + ".jsp"
		mav.addObject("name", name);
		mav.addObject("age", age);
		
		return mav; 
	}
	
	@GetMapping(path = { "/redirect" })
	public String redirect() {
		// return "/demo2/redirect-target"; // "/WEB-INF/views/" + /demo/redirect-target + ".jsp"
		return "redirect:/demo2/redirect-target";
	}
	@GetMapping(path = { "/redirect-target" })
	public String redirectTarget() {
		
		return "redirect-result"; // "/WEB-INF/views/" + redirect-result + ".jsp";
	}
	
	@GetMapping(path = { "/forward" })
	public String forward() {
		System.out.println("forward");
		return "forward:/resources/forward-result.html";
	}
	
	@GetMapping(path = { "/custom-view" })
	public View showCustomView() {

		MyView myView = new MyView();
		
		return myView;
	}
	
	
}






