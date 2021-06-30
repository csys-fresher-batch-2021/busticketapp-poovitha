package in.poovi.service;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.AdminRegisterDAO;
import in.poovi.dao.impl.AdminRegisterDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.exception.ServiceException;
import in.poovi.message.MessageConstants;
import in.poovi.model.AdminRegister;

public class AdminRegisterService {

	public static final List<AdminRegister> adminregister = new ArrayList<>();

	static AdminRegisterDAO adminregisterDAO = new AdminRegisterDAOImpl();

	/**
	 * This method is used to list the all admin details
	 * 
	 * @return allAdminRegister
	 * @throws Exception
	 */
	public List<AdminRegister> getallAdminDetails() throws Exception {
		return adminregisterDAO.findAll();
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
		adminregisterDAO.saveAdmin(adminregister);
	}

	/**
	 * This method is used to delete the admin.....
	 * 
	 * @param adminName
	 * @throws DBException 
	 */
	public static void deleteAdmin(int adminId) throws DBException {
		adminregisterDAO.deleteAdmin(adminId);
	}

	/**
	 * This method is used to display the admin details.....
	 * 
	 * @param adminid
	 * @return adminDetails
	 * @throws Exception
	 */
	public List<AdminRegister> findByAdminId(int adminid) throws Exception {
		return adminregisterDAO.findByAdminId(adminid);
	}

}
