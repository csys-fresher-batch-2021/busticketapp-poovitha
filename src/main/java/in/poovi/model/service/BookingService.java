package in.poovi.model.service;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.BookingDao;
import in.poovi.exception.DBException;
import in.poovi.exception.ServiceException;
import in.poovi.model.Booking;

public class BookingService {

	public static final List<Booking> booking = new ArrayList<>();

	static BookingDao bookingdao = new BookingDao();

	/**
	 * This method is used to display the all booking details
	 * 
	 * @return allBookingDetails
	 * @throws Exception
	 */
	public List<Booking> getReservation() throws Exception {
		return bookingdao.findallBookingDetails();
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
        double perTicketCost=bookingdao.findTicketCost(book.getBusnumber());
        double totalamount=book.getNoOfTickets()*perTicketCost;
        book.setTotalAmount(totalamount);
		bookingdao.addReservation(book);
		
	}

	/**
	 * This method is used to cancel the booking
	 * 
	 * @param agency
	 * @throws DBException 
	 */
	public static void cancelReserve(int booking) throws DBException {
          bookingdao.cancelReserve(booking);

	}

	/**
	 * This method is used to list the passenger booking details
	 * 
	 * @param pid
	 * @return listMyTicket
	 */
	public List<Booking> findMyTickets(int pid) {
		return bookingdao.findMyTicket(pid);

	}

	/**
	 * This method is used to find the ticketcost
	 * 
	 * @param busnumber
	 * @return findTicketCost
	 * @throws DBException
	 */
	public double findTicketCost(int busnumber) throws DBException {
		return bookingdao.findTicketCost(busnumber);

	}

}
