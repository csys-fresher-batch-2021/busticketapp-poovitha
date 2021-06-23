package in.poovi.model.service;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.UserRegisterDao;
import in.poovi.exception.ServiceException;
import in.poovi.message.MessageConstants;
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
		return userregisterdao.findAllUserRegisterList();
	}

	/**
	 * This method is used to add the user .......
	 * 
	 * @param userregister
	 * @throws Exception
	 */
	public void saveUser(UserRegister userregister) throws Exception {
		if (userregister.getUserName() == null || "".equals(userregister.getUserName().trim())
				|| userregister.getUserName().length() < 4) {
			throw new ServiceException(MessageConstants.INVALID_NAME);
		} else if (userregister.getPassword() == null || "".equals(userregister.getPassword().trim())
				|| userregister.getPassword().length() <= 8) {
			throw new ServiceException(MessageConstants.INVALID_PASSWORD);
		} else if (userregister.getEmail() == null || "".equals(userregister.getEmail().trim())) {
			throw new ServiceException(MessageConstants.INVALID_EMAIL);
		}

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
	int findNoOfUsers() throws Exception {
		return userregisterdao.findNoOfUsers();
	}

	/**
	 * This method is used to display the user details.....
	 * 
	 * @param userid
	 * @return userDetails
	 * @throws Exception
	 */
	public List<UserRegister> findUserById(int userid) throws Exception {
		return userregisterdao.findUserById(userid);
	}
}
