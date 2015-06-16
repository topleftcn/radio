package entity;

import java.io.Serializable;

/**
 * 保存用户信息的类
 * @author xc
 *
 */
public class User implements Serializable{

	private int id;
	private String username;
	private String password;
	private String inserttime;
	private int right;

	public User() {}

	public User(int id, String username, String password, String inserttime,
			int right) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.inserttime = inserttime;
		this.right = right;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInserttime() {
		return inserttime;
	}

	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}
}
