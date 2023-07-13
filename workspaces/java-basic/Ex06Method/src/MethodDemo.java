
public class MethodDemo {
	
	public static void drawBox() {
		
		
		
	}

	public static void main(String[] args) {
		
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
