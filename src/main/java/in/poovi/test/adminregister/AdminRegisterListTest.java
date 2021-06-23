package in.poovi.test.adminregister;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.AdminRegisterDao;
import in.poovi.exception.DBException;
import in.poovi.model.AdminRegister;

public class AdminRegisterListTest {

	
	/**
	 * This method is used to list the admin details.....
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {

		AdminRegisterDao adminregisterdao=new AdminRegisterDao();
		List<AdminRegister> adminregister=new ArrayList<>();
		adminregister=adminregisterdao.findAllAdminRegister();
		for(AdminRegister admin:adminregister) {
			System.out.println(admin);
		}
		
		
	}

}
