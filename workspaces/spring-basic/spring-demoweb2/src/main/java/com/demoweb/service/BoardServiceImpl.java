package com.demoweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demoweb.dto.BoardDto;
import com.demoweb.mapper.BoardMapper;

public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public void writeBoard(BoardDto board) {
		
		// System.out.println(board.getBoardNo()); // ---> 0
		boardMapper.insertBoard(board);	// 자동 증가 번호 생성
		// System.out.println(board.getBoardNo()); // ---> 삽입하면서 생성된 자동 증가 번호
		
	}

	@Override
	public List<BoardDto> listBoard() {
		
		List<BoardDto> boardList = boardMapper.selectAllBoard();
		return boardList;
	}
	
}
