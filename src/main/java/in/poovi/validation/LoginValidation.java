package in.poovi.validation;


public class LoginValidation {
	private LoginValidation() {
		// Default Constructor
	}

	public static boolean  isValidadminLogin(String userName, String password ,String role)  {
		boolean login=false;
		if(userName!=null && password!=null && password.length()>=8 && userName.length()>=30 && role=="admin") {
			login=true;
		}
		else {
			login=false;
		}
		return login;
	}


}
