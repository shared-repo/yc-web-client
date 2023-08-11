import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class JdbcDemoC {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// 사용자 입력 (UI 코드)
		System.out.print("성별(M/F)을 입력하세요 : ");
		String gender = scanner.nextLine();

		// 데이터 조회 ( DAO 코드 -> DAO 클래스 사용 )
		EmployeeDao dao = new EmployeeDao();
		ArrayList<EmployeeDto> employees = dao.selectEmployeesByGender(gender);
		
		// 데이터 출력 (UI 코드)
		for (EmployeeDto employee : employees) {
			System.out.println(employee.toString());
		}
		

	}

}
