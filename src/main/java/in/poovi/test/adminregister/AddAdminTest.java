package in.poovi.test.adminregister;

import in.poovi.model.AdminRegister;
import in.poovi.model.service.AdminRegisterService;

public class AddAdminTest {

	/**
	 * This main method is used to add admin details....
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		String adminName = "subburaj";
		int adminId = 1000;
		String password = "subburaj19";
		AdminRegister adminregister = new AdminRegister(adminName, adminId, password);
		AdminRegisterService adminregisterservice = new AdminRegisterService();
		adminregisterservice.saveAdmin(adminregister);
		System.out.println(adminregister);

	}

}
