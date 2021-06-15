package in.poovi.model;

public class UserRegister {

	private String userName;
	private int age;
	private String email;
	private long mobileno;
	private int userId;
	private String password;

	public UserRegister() {
		super();
	}

	public UserRegister(String userName, int age, String email, long mobileno, int userId, String password) {
		super();
		this.userName = userName;
		this.age = age;
		this.email = email;
		this.mobileno = mobileno;
		this.userId = userId;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserRegister [userName=" + userName + ", age=" + age + ", email=" + email + ", mobileno=" + mobileno
				+ ", userId=" + userId + ", password=" + password + "]";
	}

 }
