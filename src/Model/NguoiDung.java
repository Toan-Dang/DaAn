package Model;

public class NguoiDung {
	private String userName;
	private String password;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public NguoiDung(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public NguoiDung() {}
}
