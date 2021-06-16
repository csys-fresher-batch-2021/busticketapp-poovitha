package in.poovi.test.booking;

import in.poovi.model.Booking;
import in.poovi.model.service.BookingService;

public class AddReservationTest {

	/**
	 * This main method for add the reservartion from the users....
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		int bookingno = 101;
		String source = "chennai";
		String destination = "madurai";
		String agency = "bluebirds";
		int busnumber = 104;
		String bustype = "SEATER";
		double amount = 300;
		int nooftickets = 5;
		double totalamount = amount * nooftickets;
		String status = "BOOKED";
		Booking booking = new Booking(bookingno, source, destination, agency, busnumber, bustype, amount, nooftickets,
				totalamount, status);
		BookingService bookingservice = new BookingService();
		bookingservice.addReservation(booking);

	}

}
