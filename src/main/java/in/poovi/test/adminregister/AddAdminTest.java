package in.poovi.test.adminregister;

import in.poovi.logger.Logger;
import in.poovi.model.AdminRegister;
import in.poovi.service.AdminRegisterService;

public class AddAdminTest {

	/**
	 * This main method is used to add admin details....
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		String adminName = "bala";
		int adminId = 1005;
		String adminpassword = "balaji@1";
		AdminRegister adminregister = new AdminRegister(adminName, adminId, adminpassword);
		AdminRegisterService adminregisterservice = new AdminRegisterService();
		adminregisterservice.saveAdmin(adminregister);
		Logger.info(adminregister);

	}

}
