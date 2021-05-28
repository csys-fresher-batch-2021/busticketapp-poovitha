package in.poovi.dto;

public class RegisterUserDto {

	private String username;
	private String password;
	private long mobileNo;
	private String emailId;
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
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public static RegisterUserDto getInstance() {
		return instance;
	}

	private static final RegisterUserDto instance=new RegisterUserDto();
	
}
