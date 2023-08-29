package com.demoweb.dto;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

// DTO 만들기
// 1. 필드 선언
// 2. Getter, Setter
// 3. 생성자 (선택적)
// 4. 기타 다른 메서드 (선택적)

@Data
public class MemberDto {

	@NotBlank(message = "아이디를 입력하세요")
	@Pattern(regexp = "^[a-zA-Z0-9]{8,12}$", message="아이디는 영문자, 숫자 조합 8~12 문자입니다.")
	private String memberId;
	
	@NotBlank(message = "패스워드를 입력하세요")
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8}$", 
			 message="패스워드는 최소 8자, 최소 하나의 문자, 하나의 숫자 및 하나의 특수 문자를 포함해야 합니다.")
	private String passwd;
	
	@NotBlank(message="이메일을 입력하세요")
	@Email(message = "이메일 형식이 아닙니다.")
	private String email;
	
	private Date regDate;
	private String userType;
	private boolean deleted;
	
}
