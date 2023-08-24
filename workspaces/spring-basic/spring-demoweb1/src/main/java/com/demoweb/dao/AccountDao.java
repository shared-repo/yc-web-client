package com.demoweb.dao;

import com.demoweb.dto.MemberDto;

public interface AccountDao {

	// 회원가입에 사용할 메서드
	void insertMember(MemberDto member);

	// 로그인에 사용할 메서드
	MemberDto selectMemberByIdAndPasswd(String id, String passwd);

}