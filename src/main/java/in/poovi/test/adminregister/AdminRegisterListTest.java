package in.poovi.test.adminregister;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.AdminRegisterDao;
import in.poovi.model.AdminRegister;

public class AdminRegisterListTest {

	
	/**
	 * This method is used to list the admin details.....
	 * @param args
	 */
	public static void main(String[] args) {

		AdminRegisterDao adminregisterdao=new AdminRegisterDao();
		List<AdminRegister> adminregister=new ArrayList<>();
		adminregister=adminregisterdao.allAdminRegister();
		for(AdminRegister admin:adminregister) {
			System.out.println(admin);
		}
		
		
	}

}
