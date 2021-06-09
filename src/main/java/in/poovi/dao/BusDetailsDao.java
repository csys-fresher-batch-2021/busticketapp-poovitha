package in.poovi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.poovi.model.BusDetails;
import in.poovi.util.ConnectionUtil;

public class BusDetailsDao {
	/**
	 * This method is used to list the all busdetails
	 * 
	 * @return busdetails
	 */

	public List<BusDetails> allBusDetails() {
		List<BusDetails> busDetails = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "Select * from busdetails";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			busDetails = new ArrayList<>();

			while (rs.next()) {
				String agency = rs.getString("agency");
				int busnumber = rs.getInt("b_no");
				String bustype = rs.getString("bustype");
				double amount = rs.getDouble("amount");
				BusDetails bus = new BusDetails();
				bus.setAgency(agency);
				bus.setAmount(amount);
				bus.setBusnumber(busnumber);
				bus.setBusType(bustype);
				busDetails.add(bus);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return busDetails;

	}

	/**
	 * This method is used to add the busdetails in database
	 * 
	 * @param busdetails
	 */
	public void save(BusDetails busdetails) {
		Connection connection = null;
		PreparedStatement pst = null;
		String sql = "insert into busdetails(agency,b_no,bustype,amount) values ( ?,?,?,? )";
		try {
			connection = ConnectionUtil.getConnection();

			pst = connection.prepareStatement(sql);
			pst.setString(1, busdetails.getAgency().trim());
			pst.setInt(2, busdetails.getBusnumber());
			pst.setString(3, busdetails.getBusType());
			pst.setDouble(4, busdetails.getAmount());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to delete the busdetails in database
	 * 
	 * @param agency
	 */
	public void deleteBus(String agency) {
		Connection connection = null;
		PreparedStatement pst = null;

		String sql = "DELETE FROM busdetails where agency = ? ";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setString(1, agency);
			int rows = pst.executeUpdate();
			System.out.println("no of rows deleted" + rows + agency + agency.length());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

}
