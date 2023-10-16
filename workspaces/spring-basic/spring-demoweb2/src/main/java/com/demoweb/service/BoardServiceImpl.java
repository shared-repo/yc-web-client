package com.demoweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demoweb.dto.BoardAttachDto;
import com.demoweb.dto.BoardCommentDto;
import com.demoweb.dto.BoardDto;
import com.demoweb.mapper.BoardCommentMapper;
import com.demoweb.mapper.BoardMapper;

public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private BoardCommentMapper boardCommentMapper;
	
	@Override
	public void writeBoard(BoardDto board) {
		
		// 게시글 저장
		// System.out.println(board.getBoardNo()); // ---> 0
		boardMapper.insertBoard(board);	// 자동 증가 번호 생성
		// System.out.println(board.getBoardNo()); // ---> 삽입하면서 생성된 자동 증가 번호
		
		// 첨부 파일 저장
		for (BoardAttachDto attach : board.getBoardAttachList()) {
			attach.setBoardNo(board.getBoardNo());
			boardMapper.insertBoardAttach(attach);
		}
		
	}

	@Override
	public List<BoardDto> listBoard() {
		List<BoardDto> boardList = boardMapper.selectAllBoard();
		return boardList;
	}
	@Override
	public List<BoardDto> listBoardByPage(int from, int count) {
		List<BoardDto> boardList = boardMapper.selectBoardByPage(from, count);
		return boardList;
	}
	@Override
	public int getBoardCount() {
		int count = boardMapper.selectBoardCount();
		return count;
	}

	@Override
	public BoardDto findBoardByBoardNo(int boardNo) {
		BoardDto board = boardMapper.selectBoardByBoardNo(boardNo);	// 게시글 조회 (from board)
		if (board != null) {
			List<BoardAttachDto> attachList = boardMapper.selectBoardAttachByBoardNo(boardNo); // 첨부파일 조회 (from boardattach)
			board.setBoardAttachList(attachList);
			List<BoardCommentDto> commentList = boardCommentMapper.selectBoardCommentByBoardNo(boardNo);
			board.setBoardCommentList(commentList);
		}
		return board;
	}
	
	@Override
	public BoardAttachDto findBoardAttachByAttachNo(int attachNo) {
		BoardAttachDto attach = boardMapper.selectBoardAttachByAttachNo(attachNo);
		return attach;
	}
	
	@Override
	public void deleteBoard(int boardNo) {
		boardMapper.deleteBoard(boardNo);
	}
	
	@Override
	public void editBoard(BoardDto board) {
		
		// 데이터베이스 데이터 수정 ( mapper 사용 )
		boardMapper.updateBoard(board);
		
		// 첨부 파일 저장
		for (BoardAttachDto attach : board.getBoardAttachList()) {
			attach.setBoardNo(board.getBoardNo());
			boardMapper.insertBoardAttach(attach);
		}
	}

	@Override
	public void increaseMemberReadCount(int boardNo, String memberId) {
		if (memberId == null) {
			boardMapper.updateBoardReadCount2(boardNo);
		} else {
			boardMapper.updateBoardReadCount(boardNo, memberId);
			boardMapper.insertMemberReadBoard(boardNo, memberId);
		}
	}




	
}
