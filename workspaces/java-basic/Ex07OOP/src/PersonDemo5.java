
class Person5 {
	
	public int no;
	public String name;
	public String phone;
	public String email;
	
	public String info() {
		String info = String.format("[%d][%s][%s][%s]", no, name, phone, email); // 내부 접근
		return info;
	}
	
	
	///////////////////////////////////////////////////////////////////////	

}

public class PersonDemo5 {
	public static void main(String[] args) {
		
		// 1. 
		
		int i1;
		i1 = 10;
		int i2 = i1;
		i2 = 20;
		System.out.println("i1 = " + i1);
		
		Person5 p1 = new Person5();
		p1.no = 10;
		Person5 p2 = p1;
		p2.no = 20;
		System.out.println("p1.no = " + p1.no);
		
		// 2. 
		Person5[] persons = new Person5[5]; // 클래스의 배열은 참조(주소)의 배열 -> 추가로 인스턴스를 만들어야 사용할 수 있습니다.
		for (int i = 0; i < persons.length; i++) {
			// persons[i] = new Person5(); // 인스턴스를 만드는 이 구문이 없으면 오류
			persons[i].no = (i + 1);
		}
		
		for (int i = 0; i < persons.length; i++) {
			System.out.println(persons[i].no);
		}
	}
}











