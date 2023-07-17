
class Person2 {
	
	// 특성 : 변수로 표현 : 필드
	// private (접근지정자 : 외부에서 접근할 수 없음)
	private int no;
	private String name;
	private String phone;
	private String email;
	
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

public class PersonDemo2 {
	public static void main(String[] args) {
		
		Person2 person = new Person2();
		
		// person.no = 10; // 오류 : private 멤버는 외부에서 접근할 수 없습니다. --> 메서드를 통해서 접근하세요
		// System.out.println(person.no); // 오류 : private 멤버는 외부에서 접근할 수 없습니다.
		
		person.setNo(10); // person.no = 10;
		System.out.println(person.getNo());
		
		person.setName("Jane Doe");
		person.setEmail("janedoe@example.com");
		person.setPhone("010-5699-2323");
		
		String info = person.info();
		System.out.println(info);
		
	}
}











