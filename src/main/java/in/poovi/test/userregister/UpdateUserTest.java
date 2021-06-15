package in.poovi.test.userregister;

import in.poovi.dao.UserRegisterDao;
import in.poovi.model.UserRegister;

public class UpdateUserTest {

	/**
	 * This main method is used to test the updation of mobilenumber .....
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		UserRegister userregister = new UserRegister();
		userregister.setMobileno(8888888888L);
		userregister.setUserName("yamini");
		UserRegisterDao userregisterdao = new UserRegisterDao();
		userregisterdao.updateMobileno(userregister.getMobileno(), userregister.getUserName());
	}

}
