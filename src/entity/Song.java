package entity;

public class Song {
	
	private int id;
	private String songName;
	private String content;
	private String revicer;
	private String sender;
	private String inserttime;
	private int type = 0;
	
	public Song(String songName, String content, String revicer, String sender,
			String inserttime) {
		super();
		this.songName = songName;
		this.content = content;
		this.revicer = revicer;
		this.sender = sender;
		this.inserttime = inserttime;
	}
	
	public Song() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRevicer() {
		return revicer;
	}

	public void setRevicer(String revicer) {
		this.revicer = revicer;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getInserttime() {
		return inserttime;
	}

	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
