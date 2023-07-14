
class Person2 {
	
	// 특성 : 변수로 표현 : 필드
	// private (접근지정자 : 외부에서 접근할 수 없음)
	private int no;
	private String name;
	private String phone;
	private String email;
	
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
		
		PersonDemo2 person = new PersonDemo2();
		person.no = 10; // 외부 접근
		System.out.println(person.no);
		
	}
}











