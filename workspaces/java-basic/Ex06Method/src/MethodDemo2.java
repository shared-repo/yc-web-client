
public class MethodDemo2 {
	
	public static void main(String[] args) {
		
		// 영역과 지역 변수에 대한 검토
		{
			int x = 10; // 선언된 {} 범위에서 사용 가능
			{
				x = 20; // 부모 영역에서 선언된 변수는 자식 영역에서 사용 가능
			}
		}
		{
			//x = 30; // 오류 : 다른 {} 영역에서 만든 변수 사용 X
		}
		//x = 20; // 오류 : 다른 {} 영역에서 만든 변수 사용 X
		
		/////////////////////////////////////////////////////////////
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		System.out.print("박스 그리기에 사용할 문자 : ");
		String ch = scanner.nextLine();
		
		System.out.print("박스의 너비 : ");
		int width = scanner.nextInt();
		System.out.print("박스의 높이 : ");
		int height = scanner.nextInt();
		
		drawBox(ch, width, height); // 메서드 호출 ( 실행 )
		
	}

	// 메서드 정의 ( 만들기 )
	private static void drawBox(String ch, int width, int height) {
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				if (row == 0 || row == height - 1 || col == 0 || col == width - 1) {
					System.out.print(ch);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();			
		}
	}

}
