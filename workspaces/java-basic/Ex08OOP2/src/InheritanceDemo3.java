
class TheParent3 {
	String pv;
	
	void pm() {
		System.out.println("TheParent.pm()");
	}
	void m() {
		System.out.println("TheParent.m()");
	}
}
class TheChild3 extends TheParent3 { // extends : 상속 표현 --> TheParent의 모든 멤버가 TheChild에 포함
	String cv;
	
	void cm() {
		System.out.println("TheChild.cm()");
	}
	
	// 부모 클래스의 메서드 변경 (오버라이딩) : 메서드 이름, 전달인자 결과형은 동일하게 만들고 내용을 다르게 구현
	void m() {
		System.out.println("TheChild.m()");
	}
}
public class InheritanceDemo3 {	
	public static void main(String[] args) {
		TheParent3 p = new TheParent3();
		p.m(); // 오버라이딩된 메서드는 현재 타입에 따라 호출됩니다. (여기서는 TheParent3.m() 호출) 
		TheChild3 c = new TheChild3();
		c.m(); // 오버라이딩된 메서드는 현재 타입에 따라 호출됩니다. (여기서는 TheChild3.m() 호출)
		
		///
		TheParent3 p2 = new TheChild3();
		p2.m(); // 참조 타입과 인스턴스 타입이 다를 경우 재정의된 메서드의 호출 기준 (항상 인스턴스 타입 기준)
	}
	
	
}









