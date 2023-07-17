import java.util.Date;

public class ToDo {
	
	private int no;
	private String title;
	private String content;
	private java.util.Date regDate;
	
	public ToDo() {
		// do nothing
	}	
	public ToDo(int no, String title, String content, Date regDate) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
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
		String info = String.format("[%3d][%s][%s][%s]", no, title, content, regDate);
		return info;
	}

}
