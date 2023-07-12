
public class ArrayDemo01 {

	public static void main(String[] args) {
		
		// 1. 배열 만들기
		int[] ar1; // 참조변수 만들기
		ar1 = new int[10]; // 인스턴스 만들기 + 인스턴스 주소를 ar1 참조 변수에 저장 
		
		int[] ar1_1 = new int[10]; // 참조변수 만들기 + 인스턴스 만들기 + 인스턴스 주소를 ar1_1 참조 변수에 저장
		
		// 2. 배열 사용 ( 배열 요소 사용 ) - 주로 반복문과 함께 사용
		ar1[0] = 10; // ar1 배열의 0번째 요소에 10 저장
		System.out.printf("ar1[%d] = %d\n", 0, ar1[0]);
		
		for (int i = 0; i < ar1.length; i++) {
			ar1[i] = (int)(Math.random() * 900) + 100; // 100 ~ 999
		}
		for (int i = 0; i < ar1.length; i++) {
			System.out.printf("ar1[%d] = %d\n", i, ar1[i]);
		} 

	}

}
