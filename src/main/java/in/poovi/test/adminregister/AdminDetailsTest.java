package in.poovi.test.adminregister;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.AdminRegisterDao;
import in.poovi.model.AdminRegister;

public class AdminDetailsTest {

	/**
	 * This method used to display the admin details....
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		AdminRegisterDao adminregisterdao = new AdminRegisterDao();
		List<AdminRegister> adminregister = new ArrayList<>();
		adminregister = adminregisterdao.adminDetails(1000);
		for (AdminRegister admindetail : adminregister) {
			System.out.println(admindetail);
		}

	}

}
