package com.demoweb.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.demoweb.common.Util;
import com.demoweb.dao.AccountDao;
import com.demoweb.dao.JdbcAccountDao;
import com.demoweb.dto.MemberDto;
import com.demoweb.mapper.MemberMapper;

import lombok.Setter;

public class AccountServiceImpl implements AccountService {
	
	@Setter
	private AccountDao accountDao;
	
	// @Autowired
	@Setter
	private MemberMapper memberMapper;
	
	@Override
	public void register(MemberDto member) {
		
		String hashedPasswd = Util.getHashedString(member.getPasswd(), "SHA-256");
		member.setPasswd(hashedPasswd);
		
		// AccountDao accountDao = new AccountDaoImpl();
		// accountDao.insertMember(member);
		memberMapper.insertMember(member);
	}
	
	@Override
	public MemberDto findLoginMember(MemberDto member) {
		
		String hashedPasswd = Util.getHashedString(member.getPasswd(), "SHA-256");
		member.setPasswd(hashedPasswd);
		
		// AccountDao accountDao = new AccountDaoImpl();
		// MemberDto loginMember = accountDao.selectMemberByIdAndPasswd(member.getMemberId(), member.getPasswd());
		MemberDto loginMember = memberMapper.selectMemberByIdAndPasswd(member.getMemberId(), member.getPasswd());
		
		return loginMember;
	}

	@Override
	public boolean isMemberIdValid(String memberId) {
		int count = memberMapper.selectMemberCountByMemberId(memberId);
		return count == 0;
	}

}
