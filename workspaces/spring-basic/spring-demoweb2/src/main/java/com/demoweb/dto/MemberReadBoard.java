package com.demoweb.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MemberReadBoard {

	private int readNo;
	private String memberId;
	private int boardNo;
	private Date readDate;
	
}
