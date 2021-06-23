package in.poovi.test.booking;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.BookingDAO;
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
      BookingDAO bookingDAO=new BookingDAO();
      List<Booking> booking=new ArrayList<>();
      booking=bookingDAO.findMyTicket(101);
      for(Booking book:booking) {
    	  System.out.println(book);
      }
	}

}
