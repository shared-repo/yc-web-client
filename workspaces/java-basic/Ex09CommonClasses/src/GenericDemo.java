import java.util.Date;

class TheObject {
	Object v; // 정수, 실수, 문자열, 날짜 등 모든 자료형의 데이터 저장
}

class TheGeneric {
	
}

public class GenericDemo {

	public static void main(String[] args) {
		
		TheObject obj = new TheObject();
		obj.v = 10;
		obj.v = "문자열";
		obj.v = new Date();
		
		Date d = (Date)obj.v; // Object에 저장된 변수는 읽을 때 반드시 형변환 필요
		String s = (String)obj.v;
		
		System.out.println("End of program");
		
		
	}

}
