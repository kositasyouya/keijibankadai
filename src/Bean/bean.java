package Bean;

public class bean {
	public bean(String number,String name, String naiyou, String mail, String time,  String time2) {
		super();
		this.number = number;
		this.name = name;
		this.naiyou = naiyou;
		this.mail = mail;
		this.time = time;
		this.time2 = time2;
	}
	private String number;
	private String name;
	private String naiyou;
	private String mail;
	private String time;
	private String time2;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNaiyou() {
		return naiyou;
	}
	public void setNaiyou(String naiyou) {
		this.naiyou = naiyou;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

}
