package in.poovi.test.seatavailable;

import java.time.LocalDateTime;

import in.poovi.dao.SeatAvailableDAO;
import in.poovi.dao.impl.SeatAvailableDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.model.Booking;
import in.poovi.model.SeatAvailable;

public class UpdateSeatAvailableTest {

	/**
	 * This main method is used to update the seat after booking....
	 * 
	 * @param args
	 * @throws DBException
	 */
	public static void main(String[] args) throws DBException {
		SeatAvailable seatavailable = new SeatAvailable();
		seatavailable.setBusnumber(1002);
		String availableDate = "2021-06-29T10:11:30";
        LocalDateTime availabledate=LocalDateTime.parse(availableDate);
		seatavailable.setAvailableDate(availabledate);
		Booking booking =new Booking();
		LocalDateTime bookingDate=LocalDateTime.now();
		booking.setBookingDate(bookingDate);
		SeatAvailableDAO seatavailableDAO = new SeatAvailableDAOImpl();
		seatavailableDAO.updateSeatAvailable(seatavailable.getBusnumber(),seatavailable.getAvailableDate(),booking.getBookingDate());

	}

}
