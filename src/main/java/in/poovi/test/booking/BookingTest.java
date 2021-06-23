package in.poovi.test.booking;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.BookingDao;
import in.poovi.model.Booking;

public class BookingTest {
	/**
	 * Get the all booking details
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		BookingDao bookingdao = new BookingDao();
		List<Booking> booking = new ArrayList<>();
		booking = bookingdao.findallBookingDetails();
		for (Booking book : booking) {
			System.out.println(book);
		}
	}

}
