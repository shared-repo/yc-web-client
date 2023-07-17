
class Person4 {
	
	// static 멤버 (변수, 메서드) : 한 번만 만들고 모든 인스턴스가 공유하는 멤버
	public static int nextNo = 1;
	public static int getNextNo() {
		// no = 10;// 오류 : static 메서드에서 인스턴스 멤버에 접근할 수 없습니다.
		return nextNo;
	}
	
	// 특성 : 변수로 표현 : 필드
	// private (접근지정자 : 외부에서 접근할 수 없음)
	// 인스턴스 멤버 : 인스턴스마다 각각 따로 만들어서 사용하는 변수
	private int no;
	private String name;
	private String phone;
	private String email;
	
	// 생성자 : new 할 때 자동으로 호출되는 인스턴스 초기화 함수
	public Person4() {
		System.out.println("전달인자 없는 생성자 메서드가 자동으로 호출되었습니다.");
	}
	
	public Person4(int no, String name, String phone, String email) {
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

public class PersonDemo4 {
	public static void main(String[] args) {
		
		Person4 p1 = new Person4();
		p1.setNo(1);
		p1.nextNo = 1;
		
		Person4 p2 = new Person4();
		p2.setNo(2);
		p2.nextNo = 2;
		
		System.out.printf("P1 : %d - %d\n", p1.getNo(), p1.nextNo); // 1 - 2
		System.out.printf("P2 : %d - %d\n", p2.getNo(), p2.nextNo); // 2 - 2
		
		// p1.nextNo = 3; // 경고 : static 멤버는 클래스이름으로 접근
		Person4.nextNo = 3;
	}
}











