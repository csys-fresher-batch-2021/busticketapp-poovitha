package in.poovi.model.service;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.UserRegisterDao;
import in.poovi.model.UserRegister;

public class UserRegisterService {

	public static final List<UserRegister> userregister = new ArrayList<>();

	static UserRegisterDao userregisterdao = new UserRegisterDao();

	/**
	 * This method is used to display the all users.....
	 * 
	 * @return allUserRegisterDetails
	 * @throws Exception
	 */

	public List<UserRegister> getallUserDetails() throws Exception {
		return userregisterdao.allUserRegisterList();
	}

	/**
	 * This method is used to add the user .......
	 * 
	 * @param userregister
	 * @throws Exception
	 */
	public void saveUser(UserRegister userregister) throws Exception {
		userregisterdao.saveUser(userregister);
	}

	/**
	 * This method is used to update user mobileno
	 * 
	 * @param mobileno
	 * @param username
	 */
	public void Updateuser(long mobileno, String username) {
		userregisterdao.updateMobileno(mobileno, username);
		
	}

	/**
	 * This method is used to display totalcount of users.....
	 * 
	 * @return noOfUsers
	 * @throws Exception
	 */
	int noOfUsers() throws Exception {
		return userregisterdao.noOfUsers();
	}

	/**
	 * This method is used to display the user details.....
	 * 
	 * @param userid
	 * @return userDetails
	 * @throws Exception
	 */
	public List<UserRegister> userDetails(int userid) throws Exception {
		return userregisterdao.userDetails(userid);
	}
}
