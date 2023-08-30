package com.demoweb.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardCommentDto {
	
	private int commentNo;
	private int boardNo;
	private String writer;
	private String content;
	private Date regDate;
	private boolean deleted;
	
	// 글의 논리적 순서를 위한 필드 (컬럼)
	private int groupNo;	// 최상위 글과 하위 글의 집합에 부여하는 번호
	private int step;		// 같은 그룹 안에서 순서 번호
	private int depth;		// 들여쓰기 깊이
	

}



