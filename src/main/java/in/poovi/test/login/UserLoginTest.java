package in.poovi.test.login;

import in.poovi.exception.ValidationException;
import in.poovi.model.service.LoginService;

public class UserLoginTest {

	/**
	 * This main method is used for test the user login
	 * 
	 * @param args
	 * @throws ValidationException 
	 */
	public static void main(String[] args) throws ValidationException {
		String username="ravi";
		String password="ravi12345";
		boolean valid=LoginService.userLogin(username,password);
		if(valid) {
			System.out.println("login success");
		}

		else {
			System.out.println("invalid login");
		}
	}

}
