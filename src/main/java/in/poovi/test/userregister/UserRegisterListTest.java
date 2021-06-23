package in.poovi.test.userregister;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.UserRegisterDAO;
import in.poovi.model.UserRegister;

public class UserRegisterListTest {

	/**
	 * This method is used to list the all the users.....
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		UserRegisterDAO userregisterDAO = new UserRegisterDAO();
		List<UserRegister> userregister = new ArrayList<>();
		userregister = userregisterDAO.findAll();
		System.out.println(userregister);
	}

}
