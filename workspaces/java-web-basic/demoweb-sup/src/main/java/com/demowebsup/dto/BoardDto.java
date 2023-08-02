package com.demowebsup.dto;

import java.util.Date;

// DTO 만들기
// 1. 저장할 데이터를 변수로 선언
// 2. 생성자 만들기 (필요한 경우)
// 3. getter, setter 만들기

public class BoardDto {
	
	private int boardNo;
	private String title;
	private String writer;
	private String content;
	private Date writeDate;
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

}
