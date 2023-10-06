package com.demoweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demoweb.dto.BoardCommentDto;
import com.demoweb.mapper.BoardCommentMapper;

import lombok.Setter;

public class BoardCommentServiceImpl implements BoardCommentService {
	
	@Setter(onMethod_ = { @Autowired } )
	private BoardCommentMapper boardCommentMapper;
	
	@Override
	public List<BoardCommentDto> getCommentListByBoardNo(int boardNo) {
		List<BoardCommentDto> comments = boardCommentMapper.selectBoardCommentByBoardNo(boardNo);
		return comments;
	}
	
	@Override
	public void writeComment(BoardCommentDto boardComment) {
		// boardCommentMapper.getCommentNo() --> 0
		boardCommentMapper.insertComment(boardComment);
		// boardCommentMapper.getCommentNo() --> 새로 생성된 commentNo
		boardCommentMapper.updateGroupNo(boardComment.getCommentNo(), boardComment.getCommentNo());
	}

	@Override
	public void deleteComment(int commentNo) {
		boardCommentMapper.deleteComment(commentNo);
	}

	@Override
	public void editComment(BoardCommentDto boardComment) {
		boardCommentMapper.updateComment(boardComment);
	}

	@Override
	public BoardCommentDto findBoardCommentByCommentNo(int commentNo) {
		BoardCommentDto boardComment = boardCommentMapper.selectBoardCommentByCommentNo(commentNo);
		return boardComment;
		
	}

	@Override
	public void updateStep(BoardCommentDto boardComment) {
		boardCommentMapper.updateStep(boardComment);
	}

	@Override
	public void writeRecomment(BoardCommentDto boardComment) {
		boardCommentMapper.insertRecomment(boardComment);
	}



}







