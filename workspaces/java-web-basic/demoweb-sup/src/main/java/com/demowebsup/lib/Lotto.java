package com.demowebsup.lib;

public class Lotto {
	
	public int[] selectWinningNumbers() {
		// 0. 6개의 숫자를 저장할 배열 만들기
		int[] numbers; // = new int[6]; // selectBasicNumbers 메서드에서 new 처리
		double avg = 0;
		do {
			
			// 1. 6개의 숫자 뽑기 ( 조건 : 1 ~ 45, Random, 중복X ) + 배열에 저장
			numbers = selectBasicNumbers(); 
			
			// 2. 뽑힌 숫자의 평균 계산
			avg = getAverage(numbers);// 이 호출이 가능하도록 메서드 구현하세요
		
		} while (avg < 20 || avg > 26); // 3. 평균이 20 ~ 26 범위를 벗어나면 1부터 다시
		
		return numbers;
	}

	public int[] selectBasicNumbers() {
		int[] numbers = new int[6];
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
		return numbers;
	}
	
	public double getAverage(int[] numbers) {
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i]; // sum = sum + numbers[i];
		}
		double avg = (double)sum / numbers.length;
		
		return avg;
	}
	
}






