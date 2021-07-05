package in.poovi.test.booking;

import java.util.List;

import in.poovi.dao.BookingDAO;
import in.poovi.dao.impl.BookingDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.logger.Logger;
import in.poovi.model.Booking;

public class MyTicketTest {

	/**
	 * This main method is used list the booking details....
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {
      BookingDAO bookingDAO=new BookingDAOImpl();
      List<Booking> booking=bookingDAO.findMyTicket(102);// Given the passenger id
      for(Booking book:booking) {
    	  Logger.info(book);
      }
	}

}
