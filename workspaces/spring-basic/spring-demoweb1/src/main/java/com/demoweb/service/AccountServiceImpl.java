package com.demoweb.service;

import com.demoweb.dao.AccountDao;
import com.demoweb.dao.JdbcAccountDao;
import com.demoweb.dto.MemberDto;
import com.demoweb.mapper.MemberMapper;

import lombok.Setter;

public class AccountServiceImpl implements AccountService {
	
	@Setter
	private AccountDao accountDao;
	
	@Setter 
	private MemberMapper memberMapper;
	
	@Override
	public void register(MemberDto member) {
		// AccountDao accountDao = new AccountDaoImpl();
		// accountDao.insertMember(member);
		memberMapper.insertMember(member);
	}
	
	@Override
	public MemberDto findLoginMember(MemberDto member) {
		// AccountDao accountDao = new AccountDaoImpl();
		// MemberDto loginMember = accountDao.selectMemberByIdAndPasswd(member.getMemberId(), member.getPasswd());
		MemberDto loginMember = memberMapper.selectMemberByIdAndPasswd(member.getMemberId(), member.getPasswd());
		return loginMember;
	}

}
