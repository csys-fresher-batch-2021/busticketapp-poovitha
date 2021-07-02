package in.poovi.test.adminregister;

import java.util.List;

import in.poovi.dao.AdminRegisterDAO;
import in.poovi.dao.impl.AdminRegisterDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.logger.Logger;
import in.poovi.model.AdminRegister;

public class AdminRegisterListTest {

	
	/**
	 * This method is used to list the admin details.....
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {

		AdminRegisterDAO adminregisterDAO=new AdminRegisterDAOImpl();
		List<AdminRegister> adminregister=adminregisterDAO.findAll();
		for(AdminRegister admin:adminregister) {
			Logger.info(admin);
		}
		
		
	}

}
