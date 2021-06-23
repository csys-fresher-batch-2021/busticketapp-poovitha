package in.poovi.test.adminregister;

import in.poovi.dao.AdminRegisterDao;
import in.poovi.exception.DBException;

public class DeleteAdminTest {
	/**
	 * This method is used to delete the admin...
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {

		AdminRegisterDao adminregisterdao=new AdminRegisterDao();
		int adminId=1000;
		adminregisterdao.deleteAdmin(adminId);
		System.out.println("deleted " +adminId );
	}

}
