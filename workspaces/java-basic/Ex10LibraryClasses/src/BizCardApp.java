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
				BizCard bizCard = inputNewBizCard(); 	// 입력 + BizCard 인스턴스 만들기 + 입력데이터 저장
				bizCard.setNo(nextBizCardNo);			// BizCard 인스턴스에 고유 번호 저장
				nextBizCardNo++;
				bizCards.add(bizCard);	// 새로 만든 BizCard 인스턴스를 BizCard 목록 ArrayList에 추가
				break;
			case "2": // 목록 보기
				showBizCards();				
				break;
			case "3": // 검색
				System.out.print("검색할 이름 : ");
				String searchName = scanner.nextLine();
				
				ArrayList<BizCard> searchedCards = new ArrayList<BizCard>(); // 검색 결과 일치하는 BizCard를 저장할 리스트
				
				for (int i = 0; i < bizCards.size(); i++) {	// 전체 목록 순회
					BizCard bizCard3 = bizCards.get(i);
					// if (bizCard3.getName().equals(searchName)) { // 완전 일치 비교
					if (bizCard3.getName().contains(searchName)) {	// 부분 일치 비교
						searchedCards.add(bizCard3);	// 현재 반복중인 BizCard를 검색 결과 리스트에 추가
					}
				}
				
				for (int i = 0; i < searchedCards.size(); i++ ) { // 검색 결과 목록 순회
					BizCard searchedCard = searchedCards.get(i);
					System.out.println(searchedCard);
				}
				 
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
	
	/**
	 * 명함 정보 입력 받는 메서드
	 * @return 입력 받은 정보가 저장된 BizCard 인스턴스
	 */
	private BizCard inputNewBizCard() {
		// 1. BizCard 인스턴스 만들기
		BizCard bizCard = new BizCard();
		// 2. 사용자 입력 
		System.out.print("이름 : ");
		String name = scanner.nextLine();
		System.out.print("전화번호 : ");
		String phone = scanner.nextLine();
		// 3. 입력 데이터를 BizCard 인스턴스에 저장
		bizCard.setName(name);
		bizCard.setPhone(phone);
		
		return bizCard;
	}
	
	private void showBizCards() {
		System.out.println("[ 연락처 목록 ]");
//		for (int i = 0; i < bizCards.size(); i++) {
//			BizCard bizCard2 = bizCards.get(i);
		for (BizCard bizCard2 : bizCards) {
			System.out.println(bizCard2.toString());
		}
	}
	
	///////////////////////////////////////////////////////////

	public static void main(String[] args) {
		
		BizCardApp app = new BizCardApp();
		app.doManage();
		
	}

}
