package com.demoweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.demoweb.dto.MemberDto;

import lombok.Setter;

public class MyBatisAccountDao implements AccountDao {
	
	@Setter
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String MEMBER_MAPPER = "com.demoweb.mapper.MemberMapper";
	
	// 회원가입에 사용할 메서드
	@Override
	public void insertMember(MemberDto member) {
		
		sqlSessionTemplate.insert(MEMBER_MAPPER + ".insertMember", member);

	}
	
	// 로그인에 사용할 메서드
	@Override
	public MemberDto selectMemberByIdAndPasswd(String id, String passwd) {
		
		HashMap<String, Object> params = new HashMap<>(); // 다수의 데이터를 저장하는 컬렉션 변수
		params.put("memberId", id);		// 컬렉션에 데이터 추가
		params.put("passwd", passwd);
		MemberDto member = 
				sqlSessionTemplate.selectOne(MEMBER_MAPPER + ".selectMemberByIdAndPasswd", params);

		return member;
	}
	

}
