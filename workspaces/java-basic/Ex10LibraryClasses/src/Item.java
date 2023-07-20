import java.io.Serializable;

public class Item implements Serializable { // IO에 사용할 클래스는 Serializable 인터페이스를 구현해야 합니다. 
	
	private int no;
	private String name;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("[%d][%s]", no, name);
	}
	
	

}
