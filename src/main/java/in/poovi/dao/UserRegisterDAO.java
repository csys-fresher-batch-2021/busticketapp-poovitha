package in.poovi.dao;

import java.util.List;

import in.poovi.exception.DBException;
import in.poovi.model.UserRegister;

public interface UserRegisterDAO {

	/**
	 * This method is used to list the user.....
	 * 
	 * @return userregister
	 * @throws Exception
	 */

	List<UserRegister> findAll() throws DBException;

	/**
	 * used to add the user......
	 * 
	 * @param busRoute
	 * @throws DBException 
	 */
	void saveUser(UserRegister userregister) throws DBException;

	/**
	 * This method is used to update the mobileno ......
	 * 
	 * @param mobileno
	 * @param username
	 * @throws DBException 
	 */
	void updateMobileno(long mobileno, String username) throws DBException;

	/**
	 * This method is used to get user details .....
	 * 
	 * @param userid
	 * @throws Exception
	 */
	List<UserRegister> findUserById(int userid) throws DBException;

	/**
	 * This method is used to count the Number of users.....
	 * 
	 * @return usercount
	 * @throws Exception
	 */
	int findNoOfUsers() throws DBException;

}