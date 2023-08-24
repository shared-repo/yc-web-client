package com.demoweb.dto;

import java.util.Date;

import lombok.Data;

// DTO 만들기
// 1. 필드 선언
// 2. Getter, Setter
// 3. 생성자 (선택적)
// 4. 기타 다른 메서드 (선택적)

@Data
public class MemberDto {

	private String memberId;
	private String passwd;
	private String email;
	private Date regDate;
	private String userType;
	private boolean deleted;
	
}
