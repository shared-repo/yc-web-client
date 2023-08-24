package com.demoweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.demoweb.dto.MemberDto;

import lombok.Setter;

public class DataSourceAccountDao implements AccountDao {
	
	@Setter
	private DataSource dataSource;
	
	// 회원가입에 사용할 메서드
	@Override
	public void insertMember(MemberDto member) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		// ResultSet rs = null; // 조회 결과를 저장하는 변수
		
		try {
			conn = dataSource.getConnection(); // Connection Pool에서 Connection 가져오기 (생성X -> 대여O)
			
			// 3. SQL 작성
			String sql = "INSERT INTO member (memberid, passwd, email) " +
						 "VALUES (?, ?, ?) "; // ? : 데이터가 삽입될 위치 표시
						 
			// 4. 명령 객체 만들기
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId()); // SQL에 포함된 첫 번째 ?에 삽입될 데이터 지정
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getEmail());
			
			// 5. 명령 실행
			pstmt.executeUpdate();			// insert, update, delete
			// rs = pstmt.executeQuery(); 	// select 
			
			// 6. 결과가 있으면 결과 처리 ( SELECT SQL을 실행한 경우 )
			
		} catch (Exception ex) {
			ex.printStackTrace(); // 콘솔에 오류메시지 출력
		} finally {
			// 7. 연결 닫기
			// try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {} // 연결 닫기 X -> Connection Pool에 연결 반환
		}
	}
	
	
	// 로그인에 사용할 메서드
	@Override
	public MemberDto selectMemberByIdAndPasswd(String id, String passwd) {
		
		MemberDto member = null; // 조회 결과를 저장할 DTO 객체
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 조회 결과를 저장하는 변수
		try {
			conn = dataSource.getConnection(); // Connection Pool에서 Connection 가져오기 (생성X -> 대여O)
			
			// 3. SQL 작성
			String sql = "SELECT memberId, email, usertype, regdate " +
						 "FROM member " + 
						 "WHERE memberid = ? and passwd = ? "; // ? : 데이터가 삽입될 위치 표시
						 
			// 4. 명령 객체 만들기
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); // SQL에 포함된 첫 번째 ?에 삽입될 데이터 지정
			pstmt.setString(2, passwd);
			
			// 5. 명령 실행
			// pstmt.executeUpdate();	// insert, update, delete
			rs = pstmt.executeQuery(); 	// select 
			
			// 6. 결과가 있으면 결과 처리 ( SELECT SQL을 실행한 경우 )
			while (rs.next()) { // 결과 집합의 다음 행으로 이동 ( 다음 행이 없으면 false 반환 )
				member = new MemberDto(); 	// 한 행의 데이터를 저장할 MemberDto 객체 만들기
				member.setMemberId(rs.getString(1));			// 각 컬럼의 데이터를 객체의 필드에 저장
				member.setEmail(rs.getString(2));
				member.setUserType(rs.getString(3));
				member.setRegDate(rs.getDate(4));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace(); // 콘솔에 오류메시지 출력
		} finally {
			// 7. 연결 닫기
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}	// 연결 닫기 X -> Connection Pool에 연결 반환
		}
		
		return member;
	}

}
