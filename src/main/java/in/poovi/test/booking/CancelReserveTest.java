package in.poovi.test.booking;

import in.poovi.dao.BookingDao;
import in.poovi.exception.DBException;

public class CancelReserveTest {
	/**
	 * Cancel the reservation from the user....
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {
		BookingDao bookingdao = new BookingDao();
		int bookingNo = 100;
		bookingdao.cancelReserve(bookingNo);
		System.out.println("cancelled" + bookingNo);

	}

}
