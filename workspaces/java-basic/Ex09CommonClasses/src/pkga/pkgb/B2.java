package pkga.pkgb;

public class B2 {
	
	void m() {
		B b = new B();
		b.bb = 100; // public 멤버 사용
		b.bc = 200; // package 멤버 사용
	}

}
