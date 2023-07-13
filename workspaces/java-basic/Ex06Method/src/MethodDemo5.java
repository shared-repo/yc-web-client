
public class MethodDemo5 {
	
	public static void main(String[] args) {
		
//		int x = 10;
//		String x = "hello"; // 오류 : 같은 지역에서 같은 이름을 두 번 선언할 수 없습니다.
//		System.out.println(x); // 위가 오류가 아니라면 x는 ?
		
		int result = add(10, 20); // int 전달인자 2개를 사용하는 add 메서드 호출
		System.out.println(result);
		
		result = add("100", "200"); // String 전달인자 2개를 사용하는 add 메서드 호출
		System.out.println(result);
		
		int b = add(100, 200);
		add(1000, 20000); // 함수 호출의 결과를 반드시 받지 않아도 되기 때문에 결과형으로 오버로딩 할 수 없음
		
	}
	
	// 메서드 오버로딩 : 메서드는 이름 + 전달인자의 개수, 자료형, 순서를 반영해서 구분
	public static int add(int a, int b) {
		return a + b;
	}
	public static int add(String a, String b) {
		int ia = Integer.parseInt(a);
		int ib = Integer.parseInt(b);
		return ia + ib;
	}

}
