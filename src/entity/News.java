package entity;

public class News {

	private int id;
	private int type;
	private String title;
	private String content;
	private String picture;
	private String inserttime;
	
	public News() {
		// TODO Auto-generated constructor stub
	}

	public News(int type, String title, String content, String picture,
			String inserttime) {
		super();
		this.type = type;
		this.title = title;
		this.content = content;
		this.picture = picture;
		this.inserttime = inserttime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getInserttime() {
		return inserttime;
	}

	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
	}
	
}
