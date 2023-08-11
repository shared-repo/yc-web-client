
// DTO 클래스 만들기 : 데이터베이스 Employees 테이블과 일치하도록 구현

import java.util.Date;

public class EmployeeDto {

	// 필드 : Employees 테이블의 컬럼과 일치하도록 구현
	private int empNo;
	private String firstName;
	private String lastName;
	private String gender;
	private Date birthDate;
	private Date hireDate;
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	@Override
	public String toString() {
		String info = String.format("[%d][%15s][%15s][%s][%s][%s]", 
									empNo, firstName, lastName, gender, birthDate, hireDate);
		return info;
	}
	
}












