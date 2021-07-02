package in.poovi.test.userregister;

import java.util.List;
import in.poovi.dao.UserRegisterDAO;
import in.poovi.dao.impl.UserRegisterDAOImpl;
import in.poovi.logger.Logger;
import in.poovi.model.UserRegister;

public class UserDetailsTest {

	/**
	 * This main method is used to display the user details.....
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		UserRegisterDAO userregisterDAO=new UserRegisterDAOImpl();
        List<UserRegister> userregister=userregisterDAO.findUserById(100);
        for(UserRegister userdetail :userregister) {
        	Logger.info(userdetail);
        }
	}

}
