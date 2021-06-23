package in.poovi.test.booking;

import in.poovi.dao.BookingDAO;
import in.poovi.exception.DBException;

public class CancelReserveTest {
	/**
	 * Cancel the reservation from the user....
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {
		BookingDAO bookingDAO = new BookingDAO();
		int bookingNo = 100;
		bookingDAO.cancelReserve(bookingNo);
		System.out.println("cancelled" + bookingNo);

	}

}
