package in.poovi.test.adminregister;

import in.poovi.dao.AdminRegisterDAO;
import in.poovi.dao.impl.AdminRegisterDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.logger.Logger;

public class DeleteAdminTest {
	/**
	 * This method is used to delete the admin...
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {

		AdminRegisterDAO adminregisterDAO=new AdminRegisterDAOImpl();
		int adminId=1000;
		adminregisterDAO.deleteAdmin(adminId);
		Logger.log("deleted " +adminId );
	}

}
