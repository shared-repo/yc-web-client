import java.util.Date;

class TheObject {
	Object v; // 정수, 실수, 문자열, 날짜 등 모든 자료형의 데이터 저장
}

class TheGeneric<T, E> {
	T v; // 아직 구체적으로 결정되지 않은 자료형 T 타입의 변수 : 사용할 때 결정하도록 유예
	E v2;
	void m(T t) {	
	}
	E m2() {
		return null;
	}
	
}

public class GenericDemo {

	public static void main(String[] args) {
		
		TheObject obj = new TheObject();
		obj.v = 10;
		obj.v = "문자열";
		obj.v = new Date();
		
		Date d = (Date)obj.v; // Object에 저장된 변수는 읽을 때 반드시 형변환 필요
		// String s = (String)obj.v; // 형변환을 잘못하면 예외 발생
		
		//////////////////////////////////////////////////////
		
		TheGeneric<String, Integer> tg1 = new TheGeneric<>(); // TheGeneric<T, E>에서 T는 String, E는 Integer로 사용
		TheGeneric<Date, String> tg2 = new TheGeneric<>(); // TheGeneric<T, E>에서 T는 Date, E는 String로 사용
		
		tg1.v = "문자열";
		tg2.v = new Date();
		
		String s2 = tg1.v; // 읽을 때 형변환 필요하지 않음
		Date d2 = tg2.v; // 읽을 때 형변환 필요하지 않음 
		
		System.out.println("End of program");
		
		
	}

}
