package in.poovi.model.service;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.AdminRegisterDao;
import in.poovi.exception.ServiceException;
import in.poovi.message.MessageConstants;
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
		return adminregisterdao.findAllAdminRegister();
	}

	/**
	 * This method is used to add the admin .......
	 * 
	 * @param adminregister
	 * @throws Exception
	 */

	public void saveAdmin(AdminRegister adminregister) throws Exception {
		if (adminregister.getAdminName() == null || "".equals(adminregister.getAdminName().trim())
				|| adminregister.getAdminName().length() < 4) {
			throw new ServiceException(MessageConstants.INVALID_NAME);
		} else if (adminregister.getPassword() == null || "".equals(adminregister.getPassword().trim())
				|| adminregister.getPassword().length() <= 8) {
			throw new ServiceException(MessageConstants.INVALID_PASSWORD);
		}
		adminregisterdao.saveAdmin(adminregister);
	}

	/**
	 * This method is used to delete the admin.....
	 * 
	 * @param adminName
	 */
	public static void deleteAdmin(int adminId) {
		adminregisterdao.deleteAdmin(adminId);
	}

	/**
	 * This method is used to display the admin details.....
	 * 
	 * @param adminid
	 * @return adminDetails
	 * @throws Exception
	 */
	public List<AdminRegister> findAdminDetailsByAdminid(int adminid) throws Exception {
		return adminregisterdao.findAdminDetailsByAdminid(adminid);
	}

}
