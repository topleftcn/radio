package entity;

public class Bottom {
	
	private int id;
	private String phonenumber;
	private String about;
	private String year;
	private String twittwr;
	
	public Bottom() {
		// TODO Auto-generated constructor stub
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTwittwr() {
		return twittwr;
	}

	public void setTwittwr(String twittwr) {
		this.twittwr = twittwr;
	}

	public Bottom(String phonenumber, String about, String year, String twittwr) {
		super();
		this.phonenumber = phonenumber;
		this.about = about;
		this.year = year;
		this.twittwr = twittwr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
