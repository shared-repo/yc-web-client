import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

public class JdbcDemoC {

	public static void main(String[] args) {
		
		String gender = "F";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 조회 결과를 저장하는 변수
		try {
			// 1. 드라이버 준비
			// DriverManager.registerDriver(new Driver());
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. 연결 객체 만들기
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employees", // 연결할 DB 정보 
											   "devuserone", "devuserone");				// 계정 정보
			
			// 3. SQL 작성
			String sql = "SELECT emp_no, first_name, last_name, hire_date, gender " +
						 "FROM employees " + 
						 "WHERE gender = ? " + // ? : 데이터가 삽입될 위치 표시
						 "LIMIT 15 ";
			
			// 4. 명령 객체 만들기
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gender); // SQL에 포함된 첫 번째 ?에 삽입될 데이터 지정
			
			// 5. 명령 실행
			// pstmt.executeUpdate();	// insert, update, delete
			rs = pstmt.executeQuery(); 	// select 
			
			// 6. 결과가 있으면 결과 처리 ( SELECT SQL을 실행한 경우 )
			while (rs.next()) { // 결과 집합의 다음 행으로 이동 ( 다음 행이 없으면 false 반환 )
				System.out.printf("[%d][%15s][%15s][%s][%s]\n", 
								 rs.getInt(1), rs.getString(2), 
								 rs.getString("last_name"),
								 rs.getString(4), rs.getString(5));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace(); // 콘솔에 오류메시지 출력
		} finally {
			// 7. 연결 닫기
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}

	}

}
