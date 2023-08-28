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
	
	// 회원가입에 사용할 메서드
	@Override
	public void insertMember(MemberDto member) {
		
//		String sql = "INSERT INTO member (memberid, passwd, email) VALUES (?, ?, ?) "; // ? : 데이터가 삽입될 위치 표시
//		jdbcTemplate.update(sql, member.getMemberId(), member.getPasswd(), member.getEmail());
		
		sqlSessionTemplate.insert("com.demoweb.mapper.MemberMapper.insertMember", member);
			
	}
	
	// 로그인에 사용할 메서드
	@Override
	public MemberDto selectMemberByIdAndPasswd(String id, String passwd) {
		
		HashMap<String, Object> params = new HashMap<>();
		params.put("memberId", id);
		params.put("passwd", passwd);
		MemberDto member = 
				sqlSessionTemplate.selectOne("com.demoweb.mapper.MemberMapper.selectMemberByIdAndPasswd", params);

		return member;
	}

}
