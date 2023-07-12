
public class Lotto {

	public static void main(String[] args) {
		
		// 로또 번호 추출기 만들기
		
		// 0. 6개의 숫자를 저장할 배열 만들기
		int[] numbers = new int[6];
		
		// 1. 6개의 숫자 뽑기 ( 조건 : 1 ~ 45, Random, 중복X ) + 배열에 저장
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 45) + 1;
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
