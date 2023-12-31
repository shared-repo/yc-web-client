package com.demoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demoweb.dto.BoardCommentDto;
import com.demoweb.service.BoardCommentService;

import lombok.Setter;

@Controller
@RequestMapping(path = { "/board" })
public class BoardCommentController {
	
	@Setter(onMethod_ = { @Autowired }) //자동으로 만든 Setter 메서드에 @Autowired 지정 
	private BoardCommentService boardCommentService;
	
	@PostMapping(path = { "/write-comment" })
	public String writeComment(BoardCommentDto boardComment, @RequestParam(defaultValue = "-1") int pageNo) {
		if (pageNo < 1) {
			return "redirect:list";
		}
		
		boardCommentService.writeComment(boardComment);
		
		return String.format("redirect:detail?boardNo=%d&pageNo=%d", boardComment.getBoardNo(), pageNo);
	}
	
	@GetMapping(path = { "/delete-comment" })
	public String deleteComment(int commentNo, int boardNo, int pageNo) {
		
		boardCommentService.deleteComment(commentNo);
		
		return String.format("redirect:detail?boardNo=%d&pageNo=%d", boardNo, pageNo);
	}
	
	@PostMapping(path = { "/edit-comment" })
	public String editComment(BoardCommentDto boardComment, @RequestParam(defaultValue = "-1") int pageNo) {
		
		boardCommentService.editComment(boardComment);
		
		return String.format("redirect:detail?boardNo=%d&pageNo=%d", boardComment.getBoardNo(), pageNo);
	}

}









