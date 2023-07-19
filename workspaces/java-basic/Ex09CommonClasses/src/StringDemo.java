
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
		
		

	}

}
