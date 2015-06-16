package entity;

public class Index {

	private int id;
	private String english;
	private String gonggao;
	private String inserttime;
	private String zhongwen;
	public Index() {
	}
	public Index(String english, String gonggao, String inserttime,
			String zhongwen) {
		super();
		this.english = english;
		this.gonggao = gonggao;
		this.inserttime = inserttime;
		this.zhongwen = zhongwen;
	}
	
	public Index(String english, String gonggao, String inserttime) {
		super();
		this.english = english;
		this.gonggao = gonggao;
		this.inserttime = inserttime;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getGonggao() {
		return gonggao;
	}
	public void setGonggao(String gonggao) {
		this.gonggao = gonggao;
	}
	public String getInserttime() {
		return inserttime;
	}
	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
	}
	public String getZhongwen() {
		return zhongwen;
	}
	public void setZhongwen(String zhongwen) {
		this.zhongwen = zhongwen;
	}

}
