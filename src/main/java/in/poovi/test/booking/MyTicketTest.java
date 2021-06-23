package in.poovi.test.booking;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.BookingDao;
import in.poovi.exception.DBException;
import in.poovi.model.Booking;

public class MyTicketTest {

	/**
	 * This main method is used list the passenger details....
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {
      BookingDao bookingdao=new BookingDao();
      List<Booking> booking=new ArrayList<>();
      booking=bookingdao.findMyTicket(101);
      for(Booking book:booking) {
    	  System.out.println(book);
      }
	}

}
