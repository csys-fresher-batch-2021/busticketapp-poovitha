package in.poovi.model.service;

import in.poovi.validation.LoginValidation;


public class LoginService {
	public static boolean adminLogin(String adminname, String pass,String role) {
		boolean adminLogin=false;
	try {
		LoginValidation.isValidadminLogin(adminname, pass,role);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return adminLogin;
	}

	
	

}
