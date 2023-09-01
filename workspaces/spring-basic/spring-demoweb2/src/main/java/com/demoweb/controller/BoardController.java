package com.demoweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demoweb.dto.BoardDto;
import com.demoweb.dto.MemberDto;
import com.demoweb.service.BoardService;

@Controller
@RequestMapping(path = { "/board" }) // 이 컨트롤러의 메서드에 적용될 공통 경로 설정
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping(path = { "/list" })
	public String list(Model model) {
		
		// 게시물 조회 ( 서비스 객체에 요청 )
		List<BoardDto> boardList = boardService.listBoard();
		
		// View (JSP)에서 읽을 수 있도록 데이터 저장
		model.addAttribute("boardList", boardList);
		
		return "board/list"; // "/WEB-INF/views/" + board/list + ".jsp"
	}
	
	@GetMapping(path = { "/write" })
	public String showWriteForm() {
		
		// 아래 코드는 AuthInterceptor 인터셉터에서 처리
//		if (session.getAttribute("loginuser") == null) { // 로그인 하지 않은 사용자
//			return "redirect:/account/login";
//		}
		
		return "board/write"; // "/WEB-INF/views/" + board/write + ".jsp"
	}
	
	@PostMapping(path = { "/write" })
	public String write(BoardDto board) {
		
		// 아래 코드는 AuthInterceptor 인터셉터에서 처리
//		if (session.getAttribute("loginuser") == null) { // 로그인 하지 않은 사용자
//			return "redirect:/account/login";
//		}
		
		// 1. 요청 데이터 읽기 ( 전달인자에서 자동 처리 )
		// System.out.println(board);
		
		// 2. 요청 처리 ( 서비스 객체 호출 )
		boardService.writeBoard(board);
		
		// 3. JSP에서 읽을 수 있도록 데이터 저장 (선택적 - 여기서는 없음)
		
		// 4. View(jsp) 또는 다른 controller로 이동
		return "redirect:list";
	}
	
	@GetMapping(path = { "/detail" })
	public String detail(@RequestParam(defaultValue = "-1") int boardNo, Model model) {
		
		if (boardNo == -1) { // 글 번호가 요청에 포함되지 않은 경우
			return "redirect:list";
		}
		
		BoardDto board = boardService.findBoardByBoardNo(boardNo);
		
		if (board == null) { // 조회된 글이 없는 경우
			return "redirect:list";
		}
		
		model.addAttribute("board", board); // View(JSP)에서 읽을 수 있도록 저장
		
		return "board/detail";
	}
}







