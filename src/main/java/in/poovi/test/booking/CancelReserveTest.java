package in.poovi.test.booking;

import in.poovi.dao.BookingDao;

public class CancelReserveTest {

	public static void main(String[] args) {
     BookingDao bookingdao=new BookingDao();
		int bookingNo = 100;
		bookingdao.cancelReserve(bookingNo);
		System.out.println("cancelled" +bookingNo);

		
	}

}
