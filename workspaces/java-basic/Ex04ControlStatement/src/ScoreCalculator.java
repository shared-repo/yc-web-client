
public class ScoreCalculator {

	public static void main(String[] args) {
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		main : while (true) {
			System.out.println("******************************");
			System.out.println("  1. 점수 처리하기.");
			System.out.println("  2. 종료.");
			System.out.println("******************************");
			System.out.print("작업을 선택하세요 : ");
			// String selection = scanner.nextLine(); // 문자열 + 엔터까지 입력처리
			String selection = scanner.next(); // 문자열 입력 처리
			
			System.out.println();
			
			switch (selection) {
			case "1": 
				System.out.println("점수 1 : ");
				int score1 = scanner.nextInt();
				System.out.println("점수 2 : ");
				int score2 = scanner.nextInt();
				System.out.println("점수 3 : ");
				int score3 = scanner.nextInt();
				
				int sum = score1 + score2 + score3; // 총점
				int avg = sum / 3; // 평균
				char grade = 'I';
				if (avg >= 90 && avg <= 100) {
					grade = 'A';
				} else if (avg >= 80 && avg < 90) {
					grade = 'B';
				} else if (avg >= 70 && avg < 80) {
					grade = 'C';
				} else if (avg >= 60 && avg < 70) {
					grade = 'D';
				} else if (avg >= 0 && avg < 60) {
					grade = 'F';
				} else {
					System.out.println("점수 입력 오류");
				}
				if (grade != 'I') {
					System.out.printf("[TOTAL : %d][AVERAGE : %d][GRADE : %c]\n", sum, avg, grade);
				}
				break;
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
