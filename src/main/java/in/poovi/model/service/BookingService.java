package in.poovi.model.service;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.BookingDao;
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
		return bookingdao.allBookingDetails();
	}

	/**
	 * This method is used to add the booking
	 * 
	 * @param bus
	 * @throws Exception
	 */
	public void addReservation(Booking book) throws Exception {
		bookingdao.addReservation(book);
	}

	/**
	 * This method is used to cancel the booking
	 * 
	 * @param agency
	 */
	public static void cancelReserve(int booking) {

		bookingdao.cancelReserve(booking);

	}
	

}
