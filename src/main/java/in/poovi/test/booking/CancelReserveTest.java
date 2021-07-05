package in.poovi.test.booking;

import in.poovi.dao.BookingDAO;
import in.poovi.dao.impl.BookingDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.logger.Logger;

public class CancelReserveTest {
	/**
	 * Cancel the reservation from the user....
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {
		BookingDAO bookingDAO = new BookingDAOImpl();
		int bookingNo = 10006;
		bookingDAO.cancelReserve(bookingNo);
		Logger.log("cancelled" + bookingNo);

	}

}
