package in.poovi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.poovi.exception.DBException;
import in.poovi.model.Booking;
import in.poovi.util.ConnectionUtil;

public class BookingDao {
	/**
	 * This method is used to list the all booking details
	 * 
	 * @return booking
	 * @throws Exception
	 */

	public List<Booking> allBookingDetails() throws Exception {
		List<Booking> booking = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "Select * from booking";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			booking = new ArrayList<>();

			while (rs.next()) {
				int bookingno = rs.getInt("bookingno");
				String source = rs.getString("source");
				String destination = rs.getString("destination");
				String agency = rs.getString("agency");
				int busnumber = rs.getInt("busnumber");
				String bustype = rs.getString("bustype");
				double amount = rs.getDouble("amount");
				int noofTickets = rs.getInt("nooftickets");
				double totalAmount = rs.getDouble("totalamount");
				String status = rs.getString("status");
				Booking book = new Booking();
				book.setBookingNo(bookingno);
				book.setSource(source);
				book.setDestination(destination);
				book.setAgency(agency);
				book.setBusnumber(busnumber);
				book.setBusType(bustype);
				book.setAmount(amount);
				book.setNoOfTickets(noofTickets);
				book.setTotalAmount(totalAmount);
				book.setStatus(status);
				booking.add(book);

			}
		} catch (Exception e) {

			e.printStackTrace();
			throw new DBException("no data found");

		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return booking;

	}

	/**
	 * This method is used to add the booking details in database
	 * 
	 * @param booking
	 * @throws Exception
	 */
	public void addReservation(Booking booking) throws Exception {
		Connection connection = null;
		PreparedStatement pst = null;
		String sql = "insert into booking(bookingno,source,destination,agency,busnumber,bustype,amount,nooftickets,totalamount,status) values ( ?,?,?,?,?,?,?,?,?,? )";
		try {
			connection = ConnectionUtil.getConnection();

			pst = connection.prepareStatement(sql);
			pst.setInt(1, booking.getBookingNo());
			pst.setString(2, booking.getSource());
			pst.setString(3, booking.getDestination());
			pst.setString(4, booking.getAgency().trim());
			pst.setInt(5, booking.getBusnumber());
			pst.setString(6, booking.getBusType());
			pst.setDouble(7, booking.getAmount());
			pst.setInt(8, booking.getNoOfTickets());
			pst.setDouble(9, booking.getTotalAmount());
			pst.setString(10, booking.getStatus());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("unable to execute");

		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/**
	 * This method is used to cancel booking from the user....
	 * 
	 * @param agency
	 */
	public void cancelReserve(int bookingno) {
		Connection connection = null;
		PreparedStatement pst = null;

		String sql = "DELETE FROM booking where bookingno = ? ";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, bookingno);
			int rows = pst.executeUpdate();
			System.out.println("no of rows deleted" + rows + bookingno );

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}


}
