package in.poovi.test.adminregister;

import java.util.List;


import in.poovi.dao.AdminRegisterDAO;
import in.poovi.dao.impl.AdminRegisterDAOImpl;
import in.poovi.logger.Logger;
import in.poovi.model.AdminRegister;

public class AdminDetailsTest {

	/**
	 * This method used to display the admin details....
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		AdminRegisterDAO adminregisterDAO = new AdminRegisterDAOImpl();
		List<AdminRegister> adminregister =adminregisterDAO.findByAdminId(1006);
		for (AdminRegister admindetail : adminregister) {
		Logger.info(admindetail);
		}

	}

}
