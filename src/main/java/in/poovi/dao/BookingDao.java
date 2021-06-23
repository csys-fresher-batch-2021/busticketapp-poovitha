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

	public List<Booking> findallBookingDetails() throws Exception {
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
				int pid = rs.getInt("pid");
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
				book.setPid(pid);
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
		String sql = "insert into booking(bookingno,pid,source,destination,agency,busnumber,bustype,amount,nooftickets,totalamount,status) values ( ?,?,?,?,?,?,?,?,?,?,? )";
		try {
			connection = ConnectionUtil.getConnection();

			pst = connection.prepareStatement(sql);
			pst.setInt(1, booking.getBookingNo());
			pst.setInt(2, booking.getPid());
			pst.setString(3, booking.getSource());
			pst.setString(4, booking.getDestination());
			pst.setString(5, booking.getAgency().trim());
			pst.setInt(6, booking.getBusnumber());
			pst.setString(7, booking.getBusType());
			pst.setDouble(8, booking.getAmount());
			pst.setInt(9, booking.getNoOfTickets());
			pst.setDouble(10, booking.getTotalAmount());
			pst.setString(11, booking.getStatus());

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
			System.out.println("no of rows deleted" + rows + bookingno);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	public List<Booking> findMyTicket(int pid) {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from booking where pid=?";
		List<Booking> myTicket = new ArrayList<>();

		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, pid);
			rs = pst.executeQuery();
			while (rs.next()) {
				Booking booking = new Booking();
				booking.setBookingNo(rs.getInt("bookingno"));
				booking.setPid(rs.getInt("pid"));
				booking.setSource(rs.getString("source"));
				booking.setDestination(rs.getString("destination"));
				booking.setAgency(rs.getString("agency"));
				booking.setBusnumber(rs.getInt("busnumber"));
				booking.setBusType(rs.getString("bustype"));
				booking.setAmount(rs.getDouble("amount"));
				booking.setNoOfTickets(rs.getInt("nooftickets"));
				booking.setTotalAmount(rs.getDouble("totalamount"));
				booking.setStatus(rs.getString("status"));
				myTicket.add(booking);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, pst, rs);
		}
		return myTicket;

	}

	/**
	 * This method is used to find the per ticket cost
	 * 
	 * @param busnumber
	 * @return amount
	 * @throws DBException
	 */
	public double findTicketCost(int busnumber) throws DBException {
		double amount = 0;
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select amount from booking where busnumber=?";
		try {
			connection = ConnectionUtil.getConnection();
			pst = connection.prepareStatement(sql);
			pst.setInt(1, busnumber);
			rs = pst.executeQuery();
			System.out.println("amount " + busnumber);
			while (rs.next()) {
				amount = rs.getDouble("amount");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("unable to execute query");
		} finally {
			ConnectionUtil.close(connection, pst, rs);

		}
		return amount;
	}

}
