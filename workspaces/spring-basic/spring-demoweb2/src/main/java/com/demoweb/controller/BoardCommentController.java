package com.demoweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demoweb.dto.BoardCommentDto;
import com.demoweb.service.BoardCommentService;

import lombok.Setter;

@Controller
@RequestMapping(path = { "/board" })
public class BoardCommentController {
	
	@Setter(onMethod_ = { @Autowired }) //자동으로 만든 Setter 메서드에 @Autowired 지정 
	private BoardCommentService boardCommentService;
	
	@GetMapping(path = { "/comment-list" })
	public String showCommentList(int boardNo, Model model) {
		
		List<BoardCommentDto> comments = boardCommentService.getCommentListByBoardNo(boardNo);
		model.addAttribute("comments", comments);
		
		return "board/comment-list";
	}
	
	@PostMapping(path = { "/write-comment" })
	public String writeComment(BoardCommentDto boardComment, @RequestParam(defaultValue = "-1") int pageNo) {
		if (pageNo < 1) {
			return "redirect:list";
		}
		
		boardCommentService.writeComment(boardComment);
		
		return String.format("redirect:detail?boardNo=%d&pageNo=%d", boardComment.getBoardNo(), pageNo);
	}
	@PostMapping(path = { "/ajax-write-comment" })
	@ResponseBody
	public String ajaxWriteComment(BoardCommentDto boardComment, @RequestParam(defaultValue = "-1") int pageNo) {
		if (pageNo < 1) {
			return "redirect:list";
		}
		
		boardCommentService.writeComment(boardComment);
		
		return "success";
	}
	
	@GetMapping(path = { "/delete-comment" })
	public String deleteComment(int commentNo, int boardNo, int pageNo) {
		
		boardCommentService.deleteComment(commentNo);
		
		return String.format("redirect:detail?boardNo=%d&pageNo=%d", boardNo, pageNo);
	}
	@GetMapping(path = { "/ajax-delete-comment" })
	@ResponseBody
	public String ajaxDeleteComment(int commentNo) {
		
		boardCommentService.deleteComment(commentNo);
		
		return "success";
	}
	
	@PostMapping(path = { "/edit-comment" })
	public String editComment(BoardCommentDto boardComment, @RequestParam(defaultValue = "-1") int pageNo) {
		
		boardCommentService.editComment(boardComment);
		
		return String.format("redirect:detail?boardNo=%d&pageNo=%d", boardComment.getBoardNo(), pageNo);
	}
	@PostMapping(path = { "/ajax-edit-comment" })
	@ResponseBody
	public String ajaxEditComment(BoardCommentDto boardComment) {
		
		boardCommentService.editComment(boardComment);
		
		return "success";
	}

}









