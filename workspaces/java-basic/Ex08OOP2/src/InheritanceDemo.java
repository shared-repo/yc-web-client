
class TheParent {
	String pv;
	private String pv2;
	
	public TheParent() {
		System.out.println("TheParent constructor 1");
	}
	public TheParent(String pv) {
		this.pv = pv;
		System.out.println("TheParent constructor 2");
	}
	
	void pm() {
		System.out.println("TheParent.pm()");
	}
}

class TheChild extends TheParent { // extends : 상속 표현 --> TheParent의 모든 멤버가 TheChild에 포함
	String cv;
	
	public TheChild() {
		// 자식 클래스의 인스턴스 생성 -> ( 부모 클래스의 기본 생성자 메서드 호출 ) -> 자식 클래스의 생성자 메서드 호출
		super("2"); // 부모 클래스의 전달인자 있는 생성자 메서드 명시적 호출
		System.out.println("TheChild constructor");
	}
	
	void cm() {
		pv = "테스트"; // 상속 받은 멤버 사용
		super.pv = "테스트2"; // 상속 받은 멤버 명시적 사용
		// pv2 = "테스트"; // 오류 : 부모 클래스의 private 멤버는 사용할 수 없음
		System.out.println("TheChild.cm()");
	}
}

public class InheritanceDemo {
	
	public static void main(String[] args) {
		TheChild tc = new TheChild();
		tc.pm(); // 자식 클래스는 상속 받은 부모 클래스의 멤버를 포함하기 때문에 사용 가능
		tc.cm();
	}
	
	
}
