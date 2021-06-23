package in.poovi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.poovi.exception.DBException;
import in.poovi.model.SeatAvailable;
import in.poovi.util.ConnectionUtil;

public class SeatAvailableDao {
	/**
	 * This method is used to list the total available seat.....
	 * 
	 * @return booking
	 * @throws Exception
	 */

	public List<SeatAvailable> allAvailableSeat() throws Exception {
		List<SeatAvailable> seatavailable = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "Select * from seatavailable";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			seatavailable = new ArrayList<>();

			while (rs.next()) {
				int busnumber = rs.getInt("busnumber");
				int availableseat = rs.getInt("availableseat");
				int totalseat = rs.getInt("totalseat");
				SeatAvailable seat = new SeatAvailable();
				seat.setBusnumber(busnumber);
				seat.setAvailableSeat(availableseat);
				seat.setTotalSeat(totalseat);
				seatavailable.add(seat);

			}
		} catch (Exception e) {

			e.printStackTrace();
			throw new DBException("no data found");

		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return seatavailable;

	}

	/**
	 * used to add the seatavailable in bus......
	 * 
	 * @param busRoute
	 */
	public void saveSeat(SeatAvailable seatavailable) {
		Connection connection = null;
		PreparedStatement pst = null;
		String sql = "insert into seatavailable(busnumber,availableseat,totalseat) values ( ?,?,? )";
		try {
			connection = ConnectionUtil.getConnection();

			pst = connection.prepareStatement(sql);
			pst.setInt(1, seatavailable.getBusnumber());
			pst.setInt(2, seatavailable.getAvailableSeat());
			pst.setInt(3, seatavailable.getTotalSeat());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * delete the seat available......
	 * 
	 * @param routeno
	 */
	public void deleteSeat(int busnumber) {
		Connection connection = null;
		PreparedStatement pst = null;

		String sql = "DELETE FROM seatavailable where busnumber = ? ";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, busnumber);

			int rows = pst.executeUpdate();
			System.out.println("no of rows deleted " + rows + busnumber);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to update the seat available in available bus......
	 * 
	 * @param busnumber
	 * @param availableseat
	 */
	public void updateSeat(int busnumber, int availableseat) {
		Connection connection = null;
		PreparedStatement pst = null;
		String sql = "update seatavailable set availableseat=? where busnumber=?";

		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(2, busnumber);
			pst.setInt(1, availableseat);
			int rows = pst.executeUpdate();
			System.out.println("update seatavailable " + rows + busnumber + availableseat);
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionUtil.close(pst, connection);

		}

	}

	/**
	 * This method is used to available seat details along with busnumber.....
	 * 
	 * @param busnumber
	 * @return availableSeats
	 * @throws Exception
	 */
	public int seatDetails(int busnumber) throws Exception {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from seatavailable where busnumber=?";
		int availableSeats = 0;
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, busnumber);
			rs = pst.executeQuery();
			System.out.println("seat available " + busnumber);
			while (rs.next()) {
				availableSeats = rs.getInt("availableseat");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("unable to execute query");
		} finally {
			ConnectionUtil.close(connection, pst, rs);

		}
		return availableSeats;
	}

	/**
	 * This method is used to update the seatavailable when the pasenger is booked
	 * the tickets
	 * 
	 * @param busnumber
	 * @param busnumber1
	 */
	public void updateSeatAvailable(int busnumber) {
		Connection connection = null;
		PreparedStatement pst = null;
		String sql="update seatavailable s set availableseat  = (select availableseat from seatavailable where busnumber=?)-(select sum(nooftickets) from booking where busnumber=?) from busdetails where s.busnumber=busdetails.b_no and s.busnumber=?";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, busnumber);
			pst.setInt(2, busnumber);
			pst.setInt(3, busnumber);
			int rows = pst.executeUpdate();
			System.out.println("update seatavailable " + rows + busnumber);
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionUtil.close(pst, connection);

		}

	}

}
