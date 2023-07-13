
public class MethodDemo {

	public static void main(String[] args) {
		
		drawBox(); // 메서드 호출 ( 실행 )
		
	}

	// 메서드 정의 ( 만들기 )
	private static void drawBox() {
		// 20 x 10 크기의 박스 그리기
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 20; col++) {
				if (row == 0 || row == 10 - 1 || col == 0 || col == 20 - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();			
		}
	}

}
