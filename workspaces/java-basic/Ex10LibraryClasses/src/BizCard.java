
public class BizCard {
	
	// 1. 필드
	private int no;				// 관리 번호 ( 자동 증가 번호 )
	private String name;		// 이름
	private String company;		// 회사이름
	private String dept;		// 부서이름
	private String title;		// 직함
	private String email;		// 이메일
	private String phone;		// 전화번호 (휴대전화)
	
	// 2. 생성자 (constructor)
	public BizCard() {} // 전달인자 없는 생성자 메서드를 만들면 특별한 이유가 없는 한 전달인자 없는 생성자도 만듭니다.
	public BizCard(int no, String name, String phone) {
		this.no = no;
		this.name = name;
		this.phone = phone;
	}
	
	// 3. getter, setter
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	// 4. toString 메서드 재정의
	//    객체의 정보를 간단한 문자열로 반환하는 Object 클래스의 메서드
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(100);
		sb.append(String.format("[%4s] : %d\n", "번호", no))
		  .append(String.format("[%4s] : %s\n", "이름", name))
		  .append(String.format("[%4s] : %s\n", "회사", company))
		  .append(String.format("[%4s] : %s\n", "부서", dept))
		  .append(String.format("[%4s] : %s\n", "직함", title))
		  .append(String.format("[%4s] : %s\n", "이메일", email))
		  .append(String.format("[%4s] : %s\n", "전화번호", phone));
		return sb.toString();
		
	}

}
