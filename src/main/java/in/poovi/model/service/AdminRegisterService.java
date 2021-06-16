package in.poovi.model.service;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.AdminRegisterDao;
import in.poovi.model.AdminRegister;

public class AdminRegisterService {

	public static final List<AdminRegister> adminregister = new ArrayList<>();

	static AdminRegisterDao adminregisterdao = new AdminRegisterDao();

	/**
	 * This method is used to list the all admin details
	 * 
	 * @return allAdminRegister
	 * @throws Exception
	 */
	public List<AdminRegister> getallAdminDetails() throws Exception {
		return adminregisterdao.allAdminRegister();
	}

	/**
	 * This method is used to add the admin .......
	 * 
	 * @param adminregister
	 * @throws Exception
	 */

	public void saveAdmin(AdminRegister adminregister) throws Exception {
		adminregisterdao.saveAdmin(adminregister);
	}

	/**
	 * This method is used to delete the admin.....
	 * 
	 * @param adminName
	 */
	public static void deleteAdmin(String adminName) {
		adminregisterdao.deleteAdmin(adminName);
	}

	/**
	 * This method is used to display the admin details.....
	 * 
	 * @param adminid
	 * @return adminDetails
	 * @throws Exception
	 */
	public List<AdminRegister> adminDetails(int adminid) throws Exception {
		return adminregisterdao.adminDetails(adminid);
	}

}
