package in.poovi.test.userregister;

import in.poovi.dao.UserRegisterDAO;
import in.poovi.dao.impl.UserRegisterDAOImpl;
import in.poovi.logger.Logger;

public class UserCountTest {

	/**
	 * This main method is used to count the number of users registered.....
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		UserRegisterDAO userregisterDAO=new UserRegisterDAOImpl();
		int count=userregisterDAO.findNoOfUsers();
		Logger.info(count);
	}

}
