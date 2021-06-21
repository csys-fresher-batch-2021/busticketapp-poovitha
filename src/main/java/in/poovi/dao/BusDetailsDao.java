package in.poovi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import in.poovi.exception.DBException;
import in.poovi.model.BusDetails;
import in.poovi.model.SeatAvailable;
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
				String source = rs.getString("source");
				String destination = rs.getString("destination");
				double amount = rs.getDouble("amount");
				BusDetails bus = new BusDetails();
				bus.setAgency(agency);
				bus.setAmount(amount);
				bus.setBusnumber(busnumber);
				bus.setSource(source);
				bus.setDestination(destination);
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
		String sql = "insert into busdetails(agency,b_no,bustype,source,destination,amount) values ( ?,?,?,?,?,? )";
		try {
			connection = ConnectionUtil.getConnection();

			pst = connection.prepareStatement(sql);
			pst.setString(1, busdetails.getAgency().trim());
			pst.setInt(2, busdetails.getBusnumber());
			pst.setString(3, busdetails.getBusType());
			pst.setString(4, busdetails.getSource());
			pst.setString(5, busdetails.getDestination());
			pst.setDouble(6, busdetails.getAmount());

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

	/**
	 * This method is used to count the Number of buses.....
	 * 
	 * @return usercount
	 * @throws Exception
	 */
	public int noOfBuses() throws Exception {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int buscount = 0;
		String sql = "select count(*) as buscount from busdetails";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				buscount = rs.getInt("buscount");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("no data found");
		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return buscount;
	}

	/**
	 * This method is used to list the number of buslist......
	 * 
	 * @return obj
	 * @throws Exception
	 */
	public HashMap<String, Integer> noOfBuslist() throws Exception {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		HashMap<String, Integer> obj = new HashMap<String, Integer>();

		String sql = "select agency,b_no from busdetails";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String agency = rs.getString("agency");
				int busNo = rs.getInt("b_no");
				obj.put(agency, busNo);
			}

		} catch (SQLException e) {
			throw new Exception("Unable to execute resultset query");
		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return obj;

	}

	/**
	 * This method is used to display the stationlist.....
	 * 
	 * @param source
	 * @param destination
	 * @return stationlist
	 * @throws DBException
	 */
	public List<BusDetails> stationList(String source, String destination) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "select * from view_busdetails where source=? and destination=?";
		List<BusDetails> stationlist = new ArrayList<>();

		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setString(2, source);
			pst.setString(1, destination);
			rs = pst.executeQuery();
			while (rs.next()) {
				BusDetails busdetails = new BusDetails();
				busdetails.setAgency(rs.getString("agency"));
				busdetails.setBusnumber(rs.getInt("b_no"));
				busdetails.setBusType(rs.getString("bustype"));
				busdetails.setSource(rs.getString("source"));
				busdetails.setDestination(rs.getString("destination"));
				busdetails.setAmount(rs.getDouble("amount"));
				SeatAvailable s = new SeatAvailable();
				s.setTotalSeat(rs.getInt("totalseat"));
				s.setAvailableSeat(rs.getInt("availableseat"));
				busdetails.setSeatavailable(s);
				stationlist.add(busdetails);

			}
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			ConnectionUtil.close(connection, pst, rs);
			}
		return stationlist;
	}
}