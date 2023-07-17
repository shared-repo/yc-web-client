
class Person3 {
	
	// 특성 : 변수로 표현 : 필드
	// private (접근지정자 : 외부에서 접근할 수 없음)
	private int no;
	private String name;
	private String phone;
	private String email;
	
	// 생성자 : new 할 때 자동으로 호출되는 인스턴스 초기화 함수
	public Person3() {
		//this(1, "", "", ""); // 같은 클래스의 전달인자 4개인 생성자 메서드 호출
		System.out.println("전달인자 없는 생성자 메서드가 자동으로 호출되었습니다.");
	}
	
	public Person3(int no, String name, String phone, String email) {
		this(); // 같은 클래스의 전달인자 없는 생성자 메서드 호출
		System.out.println("전달인자 4개인 생성자 메서드가 자동으로 호출되었습니다.");
		// this : 클래스의 멤버를 표시하기 위해 사용하는 표현
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	
	// getter, setter : 변수에 접근하는 약속된 메서드 ( getter : 읽기, setter : 쓰기 )
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	// 기능 : 메서드로 표현
	// public (접근지정자 : 외부에서 무제한 접근할 수 있음)
	public String info() {
		String info = String.format("[%d][%s][%s][%s]", no, name, phone, email); // 내부 접근
		return info;
	}
	
	
	///////////////////////////////////////////////////////////////////////	

}

public class PersonDemo3 {
	public static void main(String[] args) {
		
		int x = 10; // 변수 초기화
		int[] ar = new int[] { 10, 20, 30 }; // 배열 초기화
		
		//////////////////////////////////////////////////
		
		Person3 person = new Person3(); // 전달인자 없는 생성자 메서드 호출
		String info = person.info();
		System.out.println(info);
		
		Person3 person2 = 
				new Person3(10, "홍길동", "010-6723-1090", "hkd@example.com"); // 전달인자 4개인 생성자 메서드 호출
		String info2 = person2.info();
		System.out.println(info2);
		
	}
}











