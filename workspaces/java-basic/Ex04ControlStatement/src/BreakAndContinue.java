
public class BreakAndContinue {

	public static void main(String[] args) {
		
		// outer는 for문에 대한 이름 ( label 문 )
		outer: for (int i = 0; i < 10; i++) {
			System.out.printf("[i = %d]\n", (i+1));
			
			inner: for (int j = 0; j < 10; j++) {
				System.out.printf("[j = %d]", (j+1));
				
				if (j == 5) {
					// break; // 자동으로 break inner;
					break outer; // outer 이름이 붙은 반복문 또는 switch문 중단
				}
			}
			
			System.out.println(); // 출력 내용이 없으면 단순 줄바꿈
			
		}

	}

}
