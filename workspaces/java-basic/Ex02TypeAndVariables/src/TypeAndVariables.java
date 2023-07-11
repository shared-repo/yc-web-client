
public class TypeAndVariables {

	public static void main(String[] args) {
		
		// 1. 변수 만들기 : 
		//    자료형 변수이름; 
		//    자료형 변수이름 = 10;
		//    자료형 변수이름1 = 10, 변수이름2 = 20; 
		
		int i1 = 10; // 이름이 i1인 4byte 정수형 변수 만들기 
		System.out.printf("i1 = %d\n", i1); // \n : enter 
		// i1 = 11.11; // 오류 : 정수형 변수에 실수형 값을 저장하면 오류
		
		double d1;
		d1 = 11.23;
		System.out.printf("d1 = %f\n", d1);
		
		// 2. 문자 자료형
		char ch = 'a'; // 내부에서는 97 저장
		System.out.println(ch); // 'a' 출력
		System.out.println((int)ch); // 97 출력  (int)ch : javascript의 parseInt(ch)와 같은 기능
		
		// 3. 문자열 자료형 (String, primitive type은 아닙니다.)
		String str = "안녕하세요!!!";
		System.out.println(str);
		String str2 = "첫 번째 행 (줄바꿈) 두 번째 행 (tab) 탭 이후의 내용 다시 (큰따옴표)처음(큰따옴표)으로";
		String str3 = "첫 번째 행 \n 두 번째 행 \t 탭 이후의 내용 다시 \"처음\"으로";
		System.out.println(str3);
		// escape sequence (탈출문자) 종류
		// \n : enter
		// \t : tab
		// \\ : \
		// \" : "
		// \' : '
		
		// 4. 진위형 (boolean)
		boolean b = true;
		System.out.println(b);
		b = false;
		System.out.println(b);
		// System.out.println((int)b); // 오류 : boolean과 int는 호환되지 않는 자료형
		
		// 5. 형변환 : 어떤 자료형의 데이터를 다른 자료형으로 변경 ( 변수의 자료형은 변경되지 않습니다. )
		int i2 = 10;
		double d2 = i2; // 형변환 : i2의 값이 int -> double : 암시적 형변환
		double d3 = 12.34;
		int i3 = (int)d3; // 형변환 d3의 값이 double -> int : 명시적 형변환
		System.out.printf("%f, %d\n", d2, i3);
		
		

	}

}










