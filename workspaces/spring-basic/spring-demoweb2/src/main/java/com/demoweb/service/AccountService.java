package com.demoweb.service;

import com.demoweb.dto.MemberDto;

public interface AccountService {

	void register(MemberDto member);

	MemberDto findLoginMember(MemberDto member);

	boolean isMemberIdValid(String memberId);

}