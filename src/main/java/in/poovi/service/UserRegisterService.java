package in.poovi.service;

import java.util.List;

import in.poovi.dao.UserRegisterDAO;
import in.poovi.dao.impl.UserRegisterDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.exception.ServiceException;
import in.poovi.message.MessageConstants;
import in.poovi.model.UserRegister;

public class UserRegisterService {

	private static UserRegisterDAO userregisterdao = new UserRegisterDAOImpl();

	/**
	 * This method is used to display the all users.....
	 * 
	 * @return allUserRegisterDetails
	 * @throws Exception
	 */

	public List<UserRegister> getallUserDetails() throws DBException {
		return userregisterdao.findAll();
	}

	/**
	 * This method is used to add the user .......
	 * 
	 * @param userregister
	 * @throws ServiceException
	 * @throws Exception
	 */
	public void saveUser(UserRegister userregister) throws DBException, ServiceException {
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
	 * @throws DBException
	 */
	public void Updateuser(long mobileno, String username) throws DBException {
		userregisterdao.updateMobileno(mobileno, username);

	}

	/**
	 * This method is used to display totalcount of users.....
	 * 
	 * @return noOfUsers
	 * @throws Exception
	 */
	int findNoOfUsers() throws DBException {
		return userregisterdao.findNoOfUsers();
	}

	/**
	 * This method is used to display the user details.....
	 * 
	 * @param userid
	 * @return userDetails
	 * @throws Exception
	 */
	public List<UserRegister> findUserById(int userid) throws DBException {
		return userregisterdao.findUserById(userid);
	}
}
