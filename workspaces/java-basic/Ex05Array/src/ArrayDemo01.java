
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
		// enhanced for
		for (int v : ar1) { // ar1의 각 요소를 순서대로 하나씩 뽑아서 v에 저장하고 반복 실행문을 실행
			System.out.printf("[%d]", v);
		}
		
		System.out.println("---------------------------------------------------");
		
		// 3. 배열 초기화 ( 배열 만들면서 즉시 일정한 값을 저장 )
		int[] ar3 = new int[5]; // new 연산자로 만든 인스턴스는 자동으로 0으로 초기화
		for (int i = 0; i < ar3.length; i++) {
			System.out.printf("ar3[%d] = %d\n", i, ar3[i]);
		}
		
		int[] ar3_1 = new int[] {1, 2, 3, 4, 5}; // {}안의 값으로 배열 요소 초기화
		for (int i = 0; i < ar3_1.length; i++) {
			System.out.printf("ar3_1[%d] = %d\n", i, ar3_1[i]);
		}
		
		int[] ar3_2 = {1, 2, 3, 4, 5}; // {}안의 값으로 배열 요소 초기화
		for (int i = 0; i < ar3_2.length; i++) {
			System.out.printf("ar3_2[%d] = %d\n", i, ar3_2[i]);
		}
		
		System.out.println("---------------------------------------------------");
		
		// 4. 2차원 배열 ( 배열의 요소가 다른 배열인 경우 )
		int[][] ar4 = new int[5][7];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				ar4[i][j] = (int)(Math.random() * 90) + 10; // 10 ~ 99
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.printf("[%d]", ar4[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("---------------------------------------------------");
		
		// 5. 2차원 배열 초기화 : {}를 중첩해서 각 배열의 초기 값 지정
		// int[][] ar5 = new int[][] {{1, 2}, {3, 4}, {5, 6}};
		int[][] ar5 = {{1, 2}, {3, 4}, {5, 6}};
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.printf("[%d]", ar5[i][j]);
			}
			System.out.println();
		}

	}

}











