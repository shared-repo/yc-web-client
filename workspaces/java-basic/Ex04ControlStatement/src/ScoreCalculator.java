
public class ScoreCalculator {

	public static void main(String[] args) {
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		main : while (true) {
			System.out.println("******************************");
			System.out.println("  1. 점수 처리하기.");
			System.out.println("  2. 종료.");
			System.out.println("******************************");
			System.out.print("작업을 선택하세요 : ");
			String selection = scanner.nextLine();
			
			System.out.println();
			
			switch (selection) {
			case "1": break;
			case "2":
				System.out.println("프로그램을 종료합니다.");
				break main;
			default:
				System.out.println("지원하지 않는 작업입니다.");
			}
			
			System.out.println();
		}
		

	}

}
