
interface TheInterface {
	
	// 1. 인터페이스는 static final 필드를 포함할 수 있습니다.
	public static final int X = 10;
	int Y = 20; // public static final을 생략하면 자동으로 적용
	
	// 2. 인터페이스는 본문이 없는 메서드 (추상메서드)만 포함할 수 있습니다. (규격)
	public abstract void m();
	String m2(String name); // public abstract를 생략하면 자동으로 적용
}

// 4. 인터페이스는 다른 클래스에 의해서 구현되는 방식으로 사용 ( 추상 메서드의 내용 채우기 )
class TheImplementation implements TheInterface { // implements : 인터페이스를 구현하는 표시 (상속과 비슷)

	// 5. 인터페이스를 구현하는 클래스는 모든 추상메서드(본문없는메서드)를 구현해야 합니다. 
	@Override
	public void m() {
		System.out.println("This is m()");
	}
	@Override
	public String m2(String name) {
		return "Hello " + name;
	} 	
}

public class InterfaceDemo {

	public static void main(String[] args) {
		
		// 3. 인터페이스는 인스턴스를 만들 수 없습니다. ( 참조 변수만 만들 수 있습니다. )
		TheInterface ti; // 참조 변수 만들기 (O)
		// ti = new TheInterface() // 인스턴스 만들기 (X)
		
		// 6. 인터페이스 참조 = 구현클래스 인스턴스 방식으로 사용
		TheInterface ti2 = new TheImplementation();
		ti2.m();
		String greetings = ti2.m2("장동건");
		System.out.println(greetings);

	}

}
