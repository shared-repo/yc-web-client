
public class ScissorsRockPaperGame {

	public static void main(String[] args) {
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		// 가위 바위 보 게임
		// 5. 사용자가 원할 때까지 반복 ( 메뉴 )
		main_loop: while (true) {
			System.out.println("******************************");
			System.out.println("* 1. 게임 시작                 *");
			System.out.println("* 2. 게임 종료                 *");
			System.out.println("******************************");
			System.out.print("[ 선택하세요 ] : ");
			String selection = scanner.next();
			
			switch (selection) {
			case "1": 
				// 1. 컴퓨터 선택 ( 난수, 0:가위 or 1:바위 or 2:보 )
				int com = (int)(Math.random() * 3); // 0, 1, 2
				
				// 2. 사용자 선택 ( 입력, 0:가위 or 1:바위 or 2:보 )
				System.out.print("[가위:0,  바위:1,  보:2] 선택 : ");
				int user = scanner.nextInt();
				
				// 3. 컴퓨터와 사용자의 선택 비교해서 승/무/패 결정
				String result = "";
				if ( (user == 0 && com == 2) || (user == 1 && com == 0) || (user == 2 && com == 1) ) {
					result = "You Win !!!";
				} else if (user == com) {
					result = "Draw !!!";
				} else {
					result = "You Lose !!!";
				}
				
				// 4. 결과 출력 ( 사용자선택, 컴퓨터선택, 결과 )
				System.out.printf("[사용자 : %d][컴퓨터 : %d][결과 : %s]\n", user, com, result);
				
				break;
			case "2": 
				System.out.println("프로그램을 종료합니다.");
				break main_loop;
			default:
				System.out.println("지원하지 않는 명령입니다.");
			}
		}
		
		
		

	}

}
