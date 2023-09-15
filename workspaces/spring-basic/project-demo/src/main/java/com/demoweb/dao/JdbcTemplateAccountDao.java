package com.demoweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.demoweb.dto.MemberDto;

import lombok.Setter;

public class JdbcTemplateAccountDao implements AccountDao {
	
	@Setter
	private JdbcTemplate jdbcTemplate;
	
	// 회원가입에 사용할 메서드
	@Override
	public void insertMember(MemberDto member) {
		
		String sql = "INSERT INTO member (memberid, passwd, email) VALUES (?, ?, ?) "; // ? : 데이터가 삽입될 위치 표시
		jdbcTemplate.update(sql, member.getMemberId(), member.getPasswd(), member.getEmail());
			
	}
	
	
	// 로그인에 사용할 메서드
	@Override
	public MemberDto selectMemberByIdAndPasswd(String id, String passwd) {

		String sql = "SELECT memberId, email, usertype, regdate " +
					 "FROM member " + 
					 "WHERE memberid = ? and passwd = ? "; // ? : 데이터가 삽입될 위치 표시
		
		MemberDto member = 
				jdbcTemplate.queryForObject(sql, 
										    new RowMapper<MemberDto>() { // RowMapper 인터페이스를 구현하는 이름 없는 클래스 만들기 + 구현 클래스의 인스턴스 만들기

												@Override
												public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
													MemberDto member = new MemberDto(); 	// 한 행의 데이터를 저장할 MemberDto 객체 만들기
													member.setMemberId(rs.getString(1));			// 각 컬럼의 데이터를 객체의 필드에 저장
													member.setEmail(rs.getString(2));
													member.setUserType(rs.getString(3));
													member.setRegDate(rs.getDate(4));
													return member;
												} 
											}, 
											id, passwd); // SQL에서 사용할 변수 (?를 대체할 값)

		return member;
	}

}
