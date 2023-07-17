
class Constants {
	
	int x1;
	final int x2; // 값을 변경할 수 없는 변수
	final int x3 = 10; // final 변수 필드 초기화 가능
	// static final int x4; // 오류 : static final 변수는 반드시 필드 초기화 해야 합니다.
	static final int x5 = 10;
	
	public Constants() {
		x1 = 10;
		x2 = 10;	// 초기화 되지 않은 final 변수는 생성자에서 값 변경 가능
		// x3 = 10;	// 오류 : 초기화 된 final 변수는 생성자에서 값 변경 불가능
		// x5 = 10; 	// 오류 : static final은 생성자에서 값 변경 불가능
	}
	
	public void m() {
		x1 = 100;
		// x2 = 100; // final 멤버는 일반 메서드에서 값 변경할 수 없습니다.
	}
	
}


public class ConstantDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
