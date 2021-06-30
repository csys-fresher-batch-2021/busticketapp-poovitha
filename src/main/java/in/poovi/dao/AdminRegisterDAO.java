package in.poovi.dao;

import java.util.List;

import in.poovi.exception.DBException;
import in.poovi.model.AdminRegister;

public interface AdminRegisterDAO {

	/**
	 * This method is used to list the all admin details
	 * 
	 * @return adminregister
	 * @throws DBException
	 */

	List<AdminRegister> findAll() throws DBException;

	/**
	 * This method is used to add the admin
	 * 
	 * @param adminregister
	 * @throws DBException
	 */
	void saveAdmin(AdminRegister adminregister) throws DBException;

	/**
	 * This method is used to delete the admin registration......
	 * 
	 * @param adminName
	 * @throws DBException 
	 */
	void deleteAdmin(int adminId) throws DBException;

	/**
	 * This method is used to get the admindetails where using adminid.....
	 * 
	 * @param adminid
	 * @return adminregister
	 * @throws Exception
	 */
	List<AdminRegister> findByAdminId(int adminid) throws Exception;

}