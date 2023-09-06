package com.demoweb.service;

import com.demoweb.dto.BoardCommentDto;

public interface BoardCommentService {

	void writeComment(BoardCommentDto boardComment);

	void deleteComment(int commentNo);

}