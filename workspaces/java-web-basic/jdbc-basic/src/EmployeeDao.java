
// Dao 클래스 : 데이터베이스 연동 기능을 구현한 클래스

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeDao {
	
	public ArrayList<EmployeeDto> selectEmployeesByGender(String gender) {
		
		ArrayList<EmployeeDto> employees = new ArrayList<EmployeeDto>(); // 조회 결과를 저장할 ArrayList 객체
		
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
				EmployeeDto employee = new EmployeeDto(); 	// 한 행의 데이터를 저장할 EmployeeDto 객체 만들기
				employee.setEmpNo(rs.getInt(1));			// 각 컬럼의 데이터를 필드에 저장
				employee.setFirstName(rs.getString(2));
				employee.setLastName(rs.getString(3));
				employee.setGender(rs.getString(4));
				employee.setBirthDate(rs.getDate(5));
				employee.setHireDate(rs.getDate(6));
				employees.add(employee); // 한 행의 데이터를 저장한 EmployeeDto 객체를 ArrayList에 추가
			}
			
		} catch (Exception ex) {
			ex.printStackTrace(); // 콘솔에 오류메시지 출력
		} finally {
			// 7. 연결 닫기
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return null;
	}

}
