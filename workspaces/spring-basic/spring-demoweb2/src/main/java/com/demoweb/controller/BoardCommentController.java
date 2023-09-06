package com.demoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demoweb.dto.BoardCommentDto;

@Controller
@RequestMapping(path = { "/board" })
public class BoardCommentController {
	
	@PostMapping(path = { "/write-comment" })
	public String writeComment(BoardCommentDto boardComment, @RequestParam(defaultValue = "-1") int pageNo) {
		if (pageNo < 1) {
			return "redirect:list";
		}
		System.out.println(boardComment);
		return String.format("redirect:detail?boardNo=%d&pageNo=%d", boardComment.getBoardNo(), pageNo);
	}

}
