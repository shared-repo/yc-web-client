package com.demoweb.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardDto {
	
	private int boardNo;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int readCount;
	private boolean deleted;
	
	// board 테이블과 boardattach 테이블 사이의 1:Many 관계를 구현하는 필드
	private List<BoardAttachDto> boardAttachList;
	// board 테이블과 boardcomment 테이블 사이의 1:Many 관계를 구현하는 필드
	private List<BoardCommentDto> boardCommentList;

}







