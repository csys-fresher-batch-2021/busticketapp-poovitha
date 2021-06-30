package in.poovi.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import in.poovi.dao.BookingDAO;
import in.poovi.dao.impl.BookingDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.exception.ServiceException;
import in.poovi.model.Booking;

public class BookingService {

	public static final List<Booking> booking = new ArrayList<>();

	static BookingDAO bookingDAO = new BookingDAOImpl();

	/**
	 * This method is used to display the all booking details
	 * 
	 * @return allBookingDetails
	 * @throws Exception
	 */
	public List<Booking> getBookings() throws Exception {
		return bookingDAO.findAll();
	}

	/**
	 * This method is used to add the booking
	 * 
	 * @param bus
	 * @throws Exception
	 */
	public void addReservation(Booking book) throws Exception {
		if (book.getSource().equals(book.getDestination())) {
			throw new ServiceException("both source and destination same we cannot booking");
		}
		try {
			double perTicketCost = bookingDAO.findTicketCost(book.getBusnumber());
			double totalamount = book.getNoOfTickets() * perTicketCost;
			book.setTotalAmount(totalamount);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("cannot find the bus number");
		}
		try {
			LocalDateTime availableDate = bookingDAO.findAvailableDate(book.getBusnumber());
			LocalDateTime journeyDate = availableDate;
			if(journeyDate.isAfter(LocalDateTime.now())) {
			book.setJourneyDate(journeyDate);
			}
			else {
				throw new ServiceException("Date expired");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("cannot find the busnumber");
		}
		bookingDAO.addReservation(book);

	}

	/**
	 * This method is used to cancel the booking
	 * 
	 * @param agency
	 * @throws DBException
	 */
	public static void cancelReserve(int booking) throws DBException {
		bookingDAO.cancelReserve(booking);

	}

	/**
	 * This method is used to list the passenger booking details
	 * 
	 * @param pid
	 * @return listMyTicket
	 * @throws DBException
	 */
	public List<Booking> findMyTickets(int pid) throws DBException {
		return bookingDAO.findMyTicket(pid);

	}

	/**
	 * This method is used to find the ticketcost
	 * 
	 * @param pid
	 * @return findTicketCost
	 * @throws DBException
	 */
	public double findTicketCost(int b_no) throws DBException {
		return bookingDAO.findTicketCost(b_no);

	}

	/**
	 * This method is used to display the filled seats
	 * 
	 * @return findFilledSeats
	 * @throws DBException
	 */
	public HashMap<Integer, Integer> findAllFilledSeats() throws DBException {
		return bookingDAO.findFilledSeats();
	}
}
