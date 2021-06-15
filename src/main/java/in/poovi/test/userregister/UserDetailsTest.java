package in.poovi.test.userregister;

import java.util.ArrayList;
import java.util.List;
import in.poovi.dao.UserRegisterDao;
import in.poovi.model.UserRegister;

public class UserDetailsTest {

	/**
	 * This main method is used to display the user details.....
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		UserRegisterDao userregisterdao=new UserRegisterDao();
        List<UserRegister> userregister=new ArrayList<>();
        userregister=userregisterdao.userDetails(102);
        for(UserRegister userdetail :userregister) {
        	System.out.println(userdetail);
        }
	}

}
