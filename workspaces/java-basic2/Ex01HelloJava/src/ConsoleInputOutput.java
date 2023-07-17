
public class ConsoleInputOutput {

	public static void main(String[] args) {
		
		// 명령행에서 사용자 입력을 받는 도구 (객체)
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : "); // 명령행에 내용 출력 + 줄바꿈 없음
		String name = scanner.nextLine(); // 명령행에서 문자열 입력 받기 + 변수에 저장

		System.out.print("나이를 입력하세요 : "); // 명령행에 내용 출력 + 줄바꿈 없음
		int age = scanner.nextInt(); // 명령행에서 숫자 입력 받기 + 변수에 저장
		
		System.out.println("[" + name + "][" + age + "]"); // 명령행에 내용 출력 + 줄바꿈 있음
		System.out.printf("[%s][%d]", name, age); // 문자열과 데이터를 결합해서 출력
		
		scanner.close(); // 입력기를 반환
		
	}

}

// printf에서 사용하는 서식 종류
// %s : 문자열
// %d : 정수
// %f : 실수
// %c : 문자
// %b : boolean










