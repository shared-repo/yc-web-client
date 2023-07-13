
public class MethodDemo4 {
	
	public static void main(String[] args) {
		
		// int[] ar = new int[] { 1, 2, 3 };
		int[] ar = { 1, 2, 3 };
		useArrayParam(ar);
		System.out.println("=================");
		useArrayParam(new int[] { 10, 20, 30});
		System.out.println("=================");
		// useArrayParam({ 100, 200, 300}); // 오류 : { 초기화 목록 } 형식은 변수 선언 구문에서만 사용
		
		//////////////////////////////////////////////////////
		
		int result = 0;
		result = sum(10, 20);
		System.out.println(result);
		result = sum(10, 20, 30);
		System.out.println(result);
		result = sum(10, 20, 30, 40);
		System.out.println(result);
		result = sum(10, 20, 30, 40, 50);
		System.out.println(result);
		
		System.out.printf("%s%d%s", 1, 2, 3);
	}
	
	public static void useArrayParam(int[] ar) {
		for (int v : ar) {
			System.out.println(v);
		}
	}
	
	public static int sum(int...values) { // ...은 불특정 개수의 전달인자를 받는 배열 전달인자 변수
		int result = 0;
		for (int v : values) {
			result += v;
		}
		return result;
	}
	

}
