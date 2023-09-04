package com.demoweb.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.demoweb.common.Util;
import com.demoweb.dto.BoardAttachDto;
import com.demoweb.dto.BoardDto;
import com.demoweb.dto.MemberDto;
import com.demoweb.service.BoardService;
import com.demoweb.ui.ThePager;

@Controller
@RequestMapping(path = { "/board" }) // 이 컨트롤러의 메서드에 적용될 공통 경로 설정
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping(path = { "/list" })
	public String list(@RequestParam(defaultValue = "1") int pageNo, Model model) {
		
		// 게시물 조회 ( 서비스 객체에 요청 )
		
		// List<BoardDto> boardList = boardService.listBoard(); // 모든 게시물 조회
		
		int pageSize = 3;			// 한 페이지에 표시될 게시물 갯수
		int pagerSize = 3;			// 표시할 페이지 번호 갯수
		String linkUrl = "list";	// list?pageNo=3과 같은 형식으로 href값 생성
		int dataCount = boardService.getBoardCount(); // 총 게시물 갯수 ( 데이터베이스에 조회 )
		
		int from = (pageNo - 1) * pageSize;	// 현재 페이지에 표시될 첫 번째 게시물 순서번호
		List<BoardDto> boardList = boardService.listBoardByPage(from, pageSize); // 페이지별 게시물 조회
		
		ThePager pager = new ThePager(dataCount, pageNo, pageSize, pagerSize, linkUrl); // 페이지 번호 표시기 만들기
		
		// View (JSP)에서 읽을 수 있도록 데이터 저장
		model.addAttribute("boardList", boardList);
		model.addAttribute("pager", pager);
		
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
	public String write(BoardDto board, MultipartFile attach, HttpServletRequest req) {
		
		// 아래 코드는 AuthInterceptor 인터셉터에서 처리
//		if (session.getAttribute("loginuser") == null) { // 로그인 하지 않은 사용자
//			return "redirect:/account/login";
//		}
		
		// 1. 요청 데이터 읽기 ( 전달인자에서 자동 처리 )
		// System.out.println(board);
		
		// 파일업로드 처리
		ArrayList<BoardAttachDto> attachList = new ArrayList<>();
		if (!attach.isEmpty()) {
			try {
				String savedFileName = Util.makeUniqueFileName(attach.getOriginalFilename());
				
				String uploadDir = req.getServletContext().getRealPath("/resources/upload/");
				attach.transferTo(new File(uploadDir, savedFileName)); // 파일을 컴퓨터에 저장
				
				// 파일 정보를 dto에 저장
				BoardAttachDto boardAttach = new BoardAttachDto();
				boardAttach.setUserFileName(attach.getOriginalFilename());
				boardAttach.setSavedFileName(savedFileName);
				
				attachList.add(boardAttach);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		board.setBoardAttachList(attachList);
		
		// 2. 요청 처리 ( 서비스 객체 호출 )
		// boardService.writeBoard(board);
		
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







