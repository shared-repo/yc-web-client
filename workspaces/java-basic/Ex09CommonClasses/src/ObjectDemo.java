

class Item /* extends Object */ { // Item 클래스는 암시적으로 Object 클래스 상속
	int no;
	String name;
	
	public Item() {}
	public Item(int no, String name) {
		this.no= no;
		this.name = name;
	}
}

public class ObjectDemo {

	public static void main(String[] args) {
		
		// 1. equals : 동일성 비교
		Item item1 = new Item(1, "홍길동");
		Item item2 = new Item(1, "홍길동");
		
		if (item1 == item2) {
			System.out.println("같습니다.");
		} else {
			System.out.println("다릅니다.");
		}
		if (item1.equals(item2)) {
			System.out.println("같습니다.");
		} else {
			System.out.println("다릅니다.");
		}

	}

}












