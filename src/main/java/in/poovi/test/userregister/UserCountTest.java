package in.poovi.test.userregister;

import in.poovi.dao.UserRegisterDao;

public class UserCountTest {

	/**
	 * This main method is used to count the number of users registered.....
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		UserRegisterDao userregisterdao=new UserRegisterDao();
		int count=userregisterdao.findNoOfUsers();
		System.out.println(count);
	}

}
