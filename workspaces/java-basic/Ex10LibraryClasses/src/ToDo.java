import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDo {
	
	private int no;
	private String title;
	private String content;
	private Date regDate;
	
	public ToDo() {
		this.regDate = new Date();
	}	
	public ToDo(int no, String title, String content /*, Date regDate */) {
		this(); // 같은 클래스의 다른 생성자 메서드 호출 (여기서는 전달인자 없는 기본 생성자 메서드 호출)
		this.no = no;
		this.title = title;
		this.content = content;
		// this.regDate = regDate;
		// this.regDate = new java.util.Date();
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public java.util.Date getRegDate() {
		return regDate;
	}
	public void setRegDate(java.util.Date regDate) {
		this.regDate = regDate;
	}
	
	public String info() {
		//날짜를 지정된 형식의 문자열로 변환하는 도구
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 9999-99-99 형식으로 변환
		String sRegDate = sdf.format(regDate); // 변환 실행
		
		String info = String.format("[%3d][%s][%s][%s]", no, title, content, sRegDate);
		return info;
	}

}












