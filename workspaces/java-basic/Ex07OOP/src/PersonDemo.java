
public class PersonDemo {

	public static void main(String[] args) {
		
		int x; // 자료형 변수;
		int[] ar = new int[10]; // 자료형 변수 = new 자료형[갯수];
		
		// 클래스 사용
		
		// 1. 인스턴스 만들기
		Person person = new Person(); // 자료형 변수 = new 자료형();

		// 2. 멤버 사용 : 참조변수.멤버이름 형식으로 사용
		person.no = 1;
		person.name = "John Doe";
		person.phone = "010-9844-1257";
		person.email = "johndoe@example.com";
		
		String info = person.info();
		System.out.println(info);
	}

}
