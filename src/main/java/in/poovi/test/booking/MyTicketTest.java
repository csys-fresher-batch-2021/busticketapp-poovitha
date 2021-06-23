package in.poovi.test.booking;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.BookingDao;
import in.poovi.model.Booking;

public class MyTicketTest {

	/**
	 * This main method is used list the passenger details....
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
      BookingDao bookingdao=new BookingDao();
      List<Booking> booking=new ArrayList<>();
      booking=bookingdao.findMyTicket(101);
      for(Booking book:booking) {
    	  System.out.println(book);
      }
	}

}
