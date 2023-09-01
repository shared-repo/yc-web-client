package com.demoweb.service;

import java.util.List;

import com.demoweb.dto.BoardDto;

public interface BoardService {

	void writeBoard(BoardDto board);
	
	List<BoardDto> listBoard();
	List<BoardDto> listBoardByPage(int from, int count);
	int getBoardCount();
	
	BoardDto findBoardByBoardNo(int boardNo);

}