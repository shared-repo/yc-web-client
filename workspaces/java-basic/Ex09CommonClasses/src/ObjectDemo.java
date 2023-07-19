

class Item /* extends Object */ { // Item 클래스는 암시적으로 Object 클래스 상속
	int no;
	String name;
	
	public Item() {}
	public Item(int no, String name) {
		this.no= no;
		this.name = name;
	}
	
	@Override // @~ : annotation 코드에 대한 부가 정보
	public boolean equals(Object obj) {
		Item other = (Item)obj;
		return this.no == other.no && this.name.equals(other.name) ; // 내용을 비교해서 일치 여부 판단.
	}
	
	@Override
	public String toString() {
		return String.format("[%d][%s]", no, name);
	}
}
public class ObjectDemo {
	public static void main(String[] args) {
		// 1. equals : 동일성 비교
		Item item1 = new Item(1, "홍길동");
		Item item2 = new Item(1, "홍길동");
		if (item1 == item2) { // 비교 연산자는 항상 주소 비교
			System.out.println("같습니다.");
		} else {
			System.out.println("다릅니다.");
		}
		if (item1.equals(item2)) { // equals의 기본 구현은 주소 비교 ( 재정의해서 동작 방식 변경 가능 )
			System.out.println("같습니다.");
		} else {
			System.out.println("다릅니다.");
		}
		// 2. toString : 인스턴스의 정보를 간단한 문자열로 반환 (기본 구현은 클래스와 주소 결합한 문자열 )
		Item item3 = new Item(2, "장동건");
		System.out.println(item3.toString());

		// 3. getClass : 클래스 정보 반환
		Item item4 = new Item(3, "김윤석");
		System.out.println(item4.getClass());
		
		// 4. hashCode : 인스턴스를 고유하게 식별할 수 있는 정수 반환 ( 기본 구현은 주소 반환 )
		
	}

}












