package com.demoweb.dto;

import lombok.Data;

@Data
public class BoardAttachDto {
	
	private int attachNo;
	private int boardNo;
	private String userFileName;	// 사용자에게 표시하는 파일 이름 ( 사용자가 업로드한 원래 파일 이름 )
	private String savedFileName;	// 실제 저장되는 파일 이름 ( 중복을 피하기 위해 고유한 파일 이름 사용 )
	private int downloadCount;

}
