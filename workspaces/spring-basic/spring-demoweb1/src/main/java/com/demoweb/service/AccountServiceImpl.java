package com.demoweb.service;

import com.demoweb.dao.AccountDao;
import com.demoweb.dao.AccountDaoImpl;
import com.demoweb.dto.MemberDto;

import lombok.Setter;

public class AccountServiceImpl implements AccountService {
	
	@Setter
	private AccountDao accountDao;
	
	@Override
	public void register(MemberDto member) {
		// AccountDao accountDao = new AccountDaoImpl();
		accountDao.insertMember(member);
	}
	
	@Override
	public MemberDto findLoginMember(MemberDto member) {
		// AccountDao accountDao = new AccountDaoImpl();
		MemberDto loginMember = accountDao.selectMemberByIdAndPasswd(member.getMemberId(), member.getPasswd());
		return loginMember;
	}

}
