package com.demoweb.dto;

import java.util.Date;

// DTO 만들기
// 1. 필드 선언
// 2. Getter, Setter
// 3. 생성자 (선택적)
// 4. 기타 다른 메서드 (선택적)

public class MemberDto {

	private String memberId;
	private String passwd;
	private String email;
	private Date regDate;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
