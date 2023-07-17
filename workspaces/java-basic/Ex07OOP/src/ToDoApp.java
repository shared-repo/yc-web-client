
public class ToDoApp {
	
	private java.util.Scanner scanner = new java.util.Scanner(System.in);
	private ToDo[] toDos = new ToDo[1000]; // 할 일을 저장, 관리하는 배열
	private int nextPosition = 0; // 다음 할 일을 등록할 때 저장할 배열의 위치 값
	
	/**
	 *  할 일 목록 관리 로직 구현 메서드
	 */
	public void doManage() { 
		
		outer : while (true) {
			String selection = selectTask();
			switch(selection) {
			case "1": break;
			case "2": break;
			case "3": break;
			case "4": break;
			case "5": break;
			case "9": 
				System.out.println("할 일 관리 프로그램을 종료합니다.");
				break outer;
			default : 
				System.out.println("지원하지 않는 작업입니다.");
				break;
			}
		}
		
	}	

	private String selectTask() {
		System.out.println("**************************************");
		System.out.println("* 1. 할 일 등록                        *");
		System.out.println("* 2. 할 일 목록 보기                    *");
		System.out.println("* 3. 할 일 검색                        *");
		System.out.println("* 4. 할 일 수정                        *");
		System.out.println("* 5. 할 일 삭제                        *");
		System.out.println("* 9. 종료                             *");
		System.out.println("**************************************");
		System.out.print("작업을 선택하세요 : ");
		String selection = scanner.nextLine();
		
		return selection;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ToDoApp toDoApp = new ToDoApp();

	}

}
