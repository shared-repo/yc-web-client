package com.demoweb.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.demoweb.dto.BoardDto;
import com.demoweb.mapper.BoardMapper;

public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public void writeBoard(BoardDto board) {
		
		boardMapper.insertBoard(board);
		
	}
	
}
