
public class Lotto {

	public static void main(String[] args) {
		
		// 로또 번호 추출기 만들기
		
		// 0. 6개의 숫자를 저장할 배열 만들기
		int[] numbers = new int[6];
		
		// 1. 6개의 숫자 뽑기 ( 조건 : 1 ~ 45, Random, 중복X ) + 배열에 저장
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 45) + 1;
			
			// 중복 검사 반복문 ( 현재 뽑힌 i번째 번호와 0 ~ i-1번째 번호 비교 )
			for (int j = 0; j < i; j++) {
				if (numbers[i] == numbers[j]) {
					i--; // i 반복문에서 i++로 넘어가는 것을 상쇄하기 위해 --처리
					// i = -1; // i 반복문에서 i를 0으로 만들어서 처음부터 다시 뽑기
					break;
				}				
			}
		}
		
		// 2. 뽑힌 숫자의 평균 계산
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i]; // sum = sum + numbers[i];
		}
		double avg = sum / numbers.length;
		
		// 3. 평균이 20 ~ 26 범위를 벗어나면 1부터 다시
		
		// 4. 뽑힌 숫자 출력
		System.out.print("[당첨 예상 번호]:");
		for (int i = 0; i < numbers.length; i++) {
			System.out.printf("[%2d]", numbers[i]); // %2d : 2칸을 확보해서 출력
		}
		System.out.printf("[%.2f]\n", avg); // %.2f : 소수점 이하 2자리 출력

		// 5. 사용자가 원할 때까지 반복 ( 메뉴 시스템으로 구현 )
	}

}
