package in.poovi.test.login;

import in.poovi.exception.ValidationException;
import in.poovi.service.LoginService;

public class AdminLoginTest {

	/**
	 * This method is used for test the admin login....
	 * 
	 * @param args
	 * @throws ValidationException
	 */
	public static void main(String[] args) throws ValidationException {
		String adminName = "raj";
		String adminPassword = "raj@19";
		boolean valid = LoginService.adminLogin(adminName, adminPassword);
		if (valid) {
			System.out.println("login success");
		}

		else {
			System.out.println("invalid login");
		}
	}
}
