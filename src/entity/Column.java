package entity;

import java.io.Serializable;

/**
 * 栏目信息类
 * @author xc_computer
 *
 */
public class Column implements Serializable{

	private int id;
	private String title;
	private String content;
	private String columntime;
	private String inserttime;
	
	public Column() {}

	public Column(int id, String title, String content, String columntime,
			String inserttime) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.columntime = columntime;
		this.inserttime = inserttime;
	}
	

	public Column(String title, String content, String columntime,
			String inserttime) {
		super();
		this.title = title;
		this.content = content;
		this.columntime = columntime;
		this.inserttime = inserttime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getColumntime() {
		return columntime;
	}

	public void setColumntime(String columntime) {
		this.columntime = columntime;
	}

	public String getInserttime() {
		return inserttime;
	}

	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
	}
}
