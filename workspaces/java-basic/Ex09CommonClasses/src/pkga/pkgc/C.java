package pkga.pkgc;

import pkga.pkgb.B;

public class C {

	void m() {
		B b = new B();
		b.bb = 100; // public 멤버 사용
		// b.bc = 200; // 오류 : 다른 패키지의 package 멤버 사용 X
	}
}
