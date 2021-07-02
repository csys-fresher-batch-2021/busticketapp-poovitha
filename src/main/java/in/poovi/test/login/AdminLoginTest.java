package in.poovi.test.login;

import in.poovi.exception.ValidationException;
import in.poovi.logger.Logger;
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
			Logger.log("login success");
		}

		else {
			Logger.log("invalid login");
		}
	}
}
