package in.poovi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.poovi.exception.DBException;
import in.poovi.message.MessageConstants;
import in.poovi.model.PassengerModel;
import in.poovi.util.ConnectionUtil;

public class PassengerListDAO {

	/**
	 * This method is used to display the passenger list.....
	 * 
	 * @return busRoute
	 * @throws DBException
	 */
	public List<PassengerModel> findAll() throws DBException {
		List<PassengerModel> passengers = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "Select pid,pname,page,pgender,pmobileno from passengerlist";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			passengers = new ArrayList<>();

			while (rs.next()) {
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				int page = rs.getInt("page");
				String pgender = rs.getString("pgender");
				long pmobileno = rs.getLong("pmobileno");
				PassengerModel passenger = new PassengerModel();
				passenger.setPid(pid);
				passenger.setPname(pname);
				passenger.setPage(page);
				passenger.setPgender(pgender);
				passenger.setPmobileno(pmobileno);
				passengers.add(passenger);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return passengers;

	}

	/**
	 * used to add the passenger details from the list......
	 * 
	 * @param busRoute
	 * @throws DBException
	 */
	public void savePassenger(PassengerModel passengermodel) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		String sql = "insert into passengerlist(pid,pname,page,pgender,pmobileno) values ( ?,?,?,?,? )";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, passengermodel.getPid());
			pst.setString(2, passengermodel.getPname().trim());
			pst.setInt(3, passengermodel.getPage());
			pst.setString(4, passengermodel.getPgender());
			pst.setLong(5, passengermodel.getPmobileno());
			int rows = pst.executeUpdate();
			System.out.println(rows);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * delete the passenger from the list......
	 * 
	 * @param pid
	 * @throws DBException
	 */
	public void deletePassenger(int pid) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		String sql = "DELETE FROM passengerlist where pid = ? ";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, pid);
			int rows = pst.executeUpdate();
			System.out.println("no of rows deleted" + rows + pid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to update the mobileno ......
	 * 
	 * @param mobileno
	 * @param pname
	 * @throws DBException 
	 */
	public void updateMobileno(long mobileno, String pname) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		String sql = "update passengerlist set pmobileno=? where pname=?";

		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setString(2, pname);
			pst.setLong(1, mobileno);
			int rows = pst.executeUpdate();
			System.out.println("update user " + rows + pname + mobileno);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(MessageConstants.UNABLE_TO_EXECUTE_QUERY);
		} finally {
			ConnectionUtil.close(pst, connection);

		}
	}

}
