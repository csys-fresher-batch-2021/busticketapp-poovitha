package in.poovi.test.userregister;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.UserRegisterDao;
import in.poovi.model.UserRegister;

public class UserRegisterListTest {

	/**
	 * This method is used to list the all the users.....
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		UserRegisterDao userregisterdao = new UserRegisterDao();
		List<UserRegister> userregister = new ArrayList<>();
		userregister = userregisterdao.allUserRegisterList();
		System.out.println(userregister);
	}

}
