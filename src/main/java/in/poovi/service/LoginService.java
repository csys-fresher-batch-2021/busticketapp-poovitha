package in.poovi.service;

import in.poovi.dao.LoginDAO;
import in.poovi.exception.ValidationException;

public class LoginService {

	private static LoginDAO logindao = new LoginDAO();

	/**
	 * This method is used for admin login...
	 * 
	 * @param adminName
	 * @param adminPassword
	 * @return adminlogin
	 * @throws ValidationException
	 */
	public static boolean adminLogin(String adminName, String adminPassword) throws ValidationException {
		boolean adminlogin = false;
		try {
			boolean adminname = LoginService.isValidAdminname(adminName);
			boolean adminpassword = LoginService.isValidPassword(adminPassword);
			if (adminname && adminpassword) {
				adminlogin = logindao.adminLogin(adminName, adminPassword);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidationException("invalid credentails");
		}
		return adminlogin;
	}

	/**
	 * This method is used for validate the adminName.....
	 * 
	 * @param adminName
	 * @return adminName
	 */
	public static boolean isValidAdminname(String adminName) {
		return ((!adminName.equals("")) && (adminName != null) && (adminName.length() >= 4)
				&& (adminName.matches("^[a-zA-Z]*$")));

	}

	/**
	 * This method is used for validate the adminpassword......
	 * 
	 * @param adminPassword
	 * @return adminPassword
	 */
	public static boolean isValidPassword(String adminPassword) {
		return ((!adminPassword.equals("")) && (adminPassword != null) && (adminPassword.length() >= 8));

	}

	/**
	 * This method is used for user login.....
	 * 
	 * @param username
	 * @param password
	 * @return user login
	 * @throws ValidationException
	 */
	public static boolean userLogin(String username, String password) throws ValidationException {
		boolean userlogin = false;
		try {
			boolean username1 = LoginService.isValidUsername(username);
			boolean password1 = LoginService.isValidUserPassword(password);
			if (username1 && password1) {
				userlogin = logindao.userLogin(username, password);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidationException("invalid credentails");
		}
		return userlogin;
	}

	/**
	 * This method is used to validate the username....
	 * 
	 * @param username
	 * @return username
	 */
	public static boolean isValidUsername(String username) {
		return ((!username.equals("")) && (username != null) && (username.length() >= 4)
				&& (username.matches("^[a-zA-Z]*$")));

	}

	/**
	 * This method is used to validate the password......
	 * 
	 * @param password
	 * @return pasword
	 */
	public static boolean isValidUserPassword(String password) {
		return ((!password.equals("")) && (password != null) && (password.length() >= 8));

	}

}
