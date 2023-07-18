import java.sql.Date;
import java.util.Scanner;

import pkga.A; // 이후에 나오는 A는 pkga.A로 해석합니다.

public class PackageDemo {

	public static void main(String[] args) {
		
		// 1. 패키지에 포함된 클래스를 사용할 때에는 패키지이름도 같이 표시해야 합니다.
		pkga.A a = new pkga.A();
		
		// 2. import 구문으로 패키지를 활성화하면 패키지에 포함된 클래스를 사용할 때 패키지이름 생략 가능
		A a2 = new A();
		// java.util.Scanner scanner = new java.util.Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		Date d = new Date(0);
		
	}

}
