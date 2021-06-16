package in.poovi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.poovi.exception.DBException;
import in.poovi.model.AdminRegister;
import in.poovi.util.ConnectionUtil;

public class AdminRegisterDao {
	/**
	 * This method is used to list the all admin details
	 * 
	 * @return adminregister
	 */

	public List<AdminRegister> allAdminRegister() {
		List<AdminRegister> adminregister = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "Select * from adminregister";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			adminregister = new ArrayList<>();

			while (rs.next()) {
				String adminName = rs.getString("adminname");
				int adminId = rs.getInt("adminid");
				String adminPassword = rs.getString("adminpassword");
				AdminRegister admin = new AdminRegister();
				admin.setAdminName(adminName);
				admin.setAdminId(adminId);
				admin.setPassword(adminPassword);
				adminregister.add(admin);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return adminregister;

	}

	/**
	 * This method is used to add the admin
	 * 
	 * @param adminregister
	 */
	public void saveAdmin(AdminRegister adminregister) {
		Connection connection = null;
		PreparedStatement pst = null;
		String sql = "insert into adminregister(adminname,adminid,adminpassword) values ( ?,?,? )";
		try {
			connection = ConnectionUtil.getConnection();

			pst = connection.prepareStatement(sql);
			pst.setString(1, adminregister.getAdminName().trim());
			pst.setInt(2, adminregister.getAdminId());
			pst.setString(3, adminregister.getPassword());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to delete the admin registration......
	 * 
	 * @param adminName
	 */
	public void deleteAdmin(String adminName) {
		Connection connection = null;
		PreparedStatement pst = null;

		String sql = "DELETE FROM adminregister where adminname = ? ";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setString(1, adminName);
			int rows = pst.executeUpdate();
			System.out.println("no of rows deleted" + rows + adminName);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to get the admindetails where using adminid.....
	 * 
	 * @param adminid
	 * @return adminregister
	 * @throws Exception
	 */
	public List<AdminRegister> adminDetails(int adminid) throws Exception {
		List<AdminRegister> adminregister = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from adminregister where adminid=?";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, adminid);
			rs = pst.executeQuery();
			adminregister = new ArrayList<>();
			while (rs.next()) {
				String adminName = rs.getString("adminname");
				int adminId = rs.getInt("adminid");
				String password = rs.getString("password");
				AdminRegister admin = new AdminRegister();
				admin.setAdminName(adminName);
				admin.setAdminId(adminId);
				admin.setPassword(password);
				adminregister.add(admin);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("unable to execute query");
		} finally {
			ConnectionUtil.close(pst, connection);

		}
		return adminregister;
	}

}
