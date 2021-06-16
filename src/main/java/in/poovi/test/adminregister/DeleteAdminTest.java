package in.poovi.test.adminregister;

import in.poovi.dao.AdminRegisterDao;

public class DeleteAdminTest {
	/**
	 * This method is used to delete the admin...
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		AdminRegisterDao adminregisterdao=new AdminRegisterDao();
		String adminName="subburaj";
		adminregisterdao.deleteAdmin(adminName);
		System.out.println("deleted " +adminName );
	}

}
