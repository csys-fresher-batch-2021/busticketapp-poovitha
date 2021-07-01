package in.poovi.dao;

import in.poovi.exception.DBException;

public interface LoginDAO {

	/**
	 * This method is used to admin login
	 * 
	 * @param adminName
	 * @param adminPassword
	 * @return valid
	 * @throws Exception
	 */
	boolean adminLogin(String adminName, String adminPassword) throws DBException;

	/**
	 * This method is used for login user....
	 * 
	 * @param username
	 * @param password
	 * @return valid
	 * @throws DBException 
	 * @throws Exception
	 */
	boolean userLogin(String username, String password) throws DBException;

}