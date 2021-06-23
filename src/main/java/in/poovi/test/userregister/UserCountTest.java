package in.poovi.test.userregister;

import in.poovi.dao.UserRegisterDAO;

public class UserCountTest {

	/**
	 * This main method is used to count the number of users registered.....
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		UserRegisterDAO userregisterDAO=new UserRegisterDAO();
		int count=userregisterDAO.findNoOfUsers();
		System.out.println(count);
	}

}
