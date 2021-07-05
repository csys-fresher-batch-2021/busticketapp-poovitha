package in.poovi.test.booking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import in.poovi.logger.Logger;
import in.poovi.model.Booking;
import in.poovi.service.BookingService;

public class AddReservationTest {
	 static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	/**
	 * This main method for add the reservartion from the users....
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		int bookingno = 10011;
		int pid = 101;
		String source = "thirchy";
		String destination = "theni";
		String agency = "jai travels";
		int busnumber = 1000;
		String bustype = "AcSleeper";
		double amount = 300;
		int nooftickets = 5;
		double totalamount=0;
		LocalDateTime bookingDate = LocalDateTime.now();
		final LocalDateTime journeyDate = null ;
		String status = "booked";
		Booking booking = new Booking(bookingno, pid, source, destination, agency, busnumber, bustype, amount,
				nooftickets, totalamount, bookingDate, journeyDate, status);
		BookingService bookingservice = new BookingService();
		bookingservice.addReservation(booking);
		Logger.info(booking);
	}

}
