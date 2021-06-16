package in.poovi.model;

public class AdminRegister {

	private String adminName;
	private int adminId;
	private String password;

	public AdminRegister() {
		super();
	}

	public AdminRegister(String adminName, int adminId, String password) {
		super();
		this.adminName = adminName;
		this.adminId = adminId;
		this.password = password;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminRegister [adminName=" + adminName + ", adminId=" + adminId + ", password=" + password + "]";
	}

}
