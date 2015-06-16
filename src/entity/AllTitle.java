package entity;

public class AllTitle {

	private int id;
	private int type;
	private String title;
	private String content;
	private String picture;
	
	public AllTitle() {
		// TODO Auto-generated constructor stub
	}

	public AllTitle(int type, String title, String content, String picture) {
		super();
		this.type = type;
		this.title = title;
		this.content = content;
		this.picture = picture;
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
}
