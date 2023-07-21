import java.util.ArrayList;
import java.util.Scanner;

public class BizCardApp {
	
	private Scanner scanner = new Scanner(System.in);
	private int nextBizCardNo = 1; 			// 명함 번호에 적용할 자동 증가 번호 변수
	private ArrayList<BizCard> bizCards;	// 명함 목록을 저장할 변수
	
	public BizCardApp() {
		bizCards = new ArrayList<BizCard>();
	}
	
	////////////////////////////////////////////////////
	
	public void doManage() { 
		
		outer : while (true) {
			String selection = selectTask();
			switch(selection) {
			case "1": // 등록
				break;
			case "2": // 목록 보기
				break;
			case "3": // 검색 
				break;
			case "4": // 수정
				break;
			case "5": // 삭제
				break;
			case "6": // 저장
				break;
			case "9": // 종료
				System.out.println("명함 관리 프로그램을 종료합니다.");
				break outer;
			default : 
				System.out.println("지원하지 않는 작업입니다.");
				break;
			}
		}
		
	}
	
	////////////////////////////////////////////////////
	
	private String selectTask() {
		System.out.println("************************************");
		System.out.println("* 1. 명함 등록                        *");
		System.out.println("* 2. 명함 목록 보기                     *");
		System.out.println("* 3. 명함 검색                        *");
		System.out.println("* 4. 명함 수정                        *");
		System.out.println("* 5. 명함 삭제                        *");
		System.out.println("* 6. 명함 저장                        *");
		System.out.println("* 9. 종료                            *");
		System.out.println("************************************");
		System.out.print("작업을 선택하세요 : ");
		String selection = scanner.nextLine();
		
		return selection;
	}
	
	///////////////////////////////////////////////////////////

	public static void main(String[] args) {
		
		BizCardApp app = new BizCardApp();
		app.doManage();
		
	}

}
