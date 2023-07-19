
public class StringDemo {

	public static void main(String[] args) {
		
		// 1. 문자열 리터럴 ("문자열")은 그 문자열이 저장되어있는 주소 --> 같은 문자열 리터럴은 항상 같은 인스턴스
		String str1 = "Hello";
		String str2 = "Hello";
		
		System.out.println( (str1 == str2) );
		System.out.println( (str1.equals(str2) ) );
		
		// 2. 
		String str3 = new String("Hello");
		String str4 = new String("Hello");
		
		System.out.println( (str3 == str4) );
		System.out.println( (str4.equals(str3) ) );
		
		// 3. String 문자열은 고정형(불변형) : 한 번 만든 문자열은 변경 불가능
		String str5 = new String("처음 문자열");
		String str6 = str5;
		str6 = str6 + " 추가된 문자열"; // 기존 문자열을 변경하지 않고 새 문자열을 만들어서 연산 결과 저장 
									 // 그러므로 문자열을 연산하는 것은 권장하지 않습니다.
		
		System.out.println( str5 == str6 );
		System.out.println( str5.equals(str6) );
		
		// 4. 문자열을 연산하는 경우 StringBuilder 사용하세요
		StringBuilder sb = new StringBuilder(32);
		sb.append("처음 문자열");			// 공간에 여유가 있다면 기존 문자열에 추가
		sb.append(" 추가된 문자열");		// 공간에 여유가 있다면 기존 문자열에 추가
		sb.append(" 다시 추가된 문자열");	// 공간에 여유가 있다면 기존 문자열에 추가
		System.out.println(sb.toString());
		
		
		
		

	}

}
