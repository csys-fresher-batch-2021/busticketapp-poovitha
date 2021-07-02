package in.poovi.test.booking;

import java.util.List;

import in.poovi.dao.BookingDAO;
import in.poovi.dao.impl.BookingDAOImpl;
import in.poovi.logger.Logger;
import in.poovi.model.Booking;

public class BookingTest {
	/**
	 * Get the all booking details
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		BookingDAO bookingDAO = new BookingDAOImpl();
		List<Booking> booking =bookingDAO.findAll();
		for (Booking book : booking) {
			Logger.info(book);
		}
	}

}
