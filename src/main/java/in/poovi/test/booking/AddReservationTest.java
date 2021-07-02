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
		int bookingno = 10009;
		int pid = 105;
		String source = "madurai";
		String destination = "chennai";
		String agency = "red bus";
		int busnumber = 1001;
		String bustype = "NonAc Seater";
		double amount = 700;
		int nooftickets = 2;
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
