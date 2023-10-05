package com.demoweb.service;

import java.util.List;

import com.demoweb.dto.BoardCommentDto;

public interface BoardCommentService {

	void writeComment(BoardCommentDto boardComment);

	void deleteComment(int commentNo);

	void editComment(BoardCommentDto boardComment);

	List<BoardCommentDto> getCommentListByBoardNo(int boardNo);

}