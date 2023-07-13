
public class MethodDemo4 {
	
	public static void main(String[] args) {
		
		int d1 = 10, d2 = 20;
		int result = sum(d1, d2);
		
		System.out.println(result);
		
	}
	
	
	// 두 정수를 더하는 함수 만들기
	// void return type : 반환 값 없음
	public static int sum(int d1, int d2) {	
		
		int result = d1 + d2;
		return result; // return; --> 함수 종료, return 값; --> 함수를 종료하고 호출한 곳으로 값 반환
		
	}

}
