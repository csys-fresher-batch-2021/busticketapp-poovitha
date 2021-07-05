package in.poovi.test.userregister;


import in.poovi.logger.Logger;
import in.poovi.model.UserRegister;
import in.poovi.service.UserRegisterService;

public class AddUserTest {

	/**
	 * This main method is used to add the user..
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		String username="yamini";
		int age =20;
		String email="yamini@gmail.com";
		long mobileno=9999999988L;
		int userid=100;
		String password="yamini228";
		UserRegister userregister=new UserRegister(username,age,email,mobileno,userid,password);
		UserRegisterService userregisterservice=new UserRegisterService();
		userregisterservice.saveUser(userregister);
		Logger.info(userregister);
		
		
	}

}
