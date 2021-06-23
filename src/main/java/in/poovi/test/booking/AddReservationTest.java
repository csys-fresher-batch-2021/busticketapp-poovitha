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
		int bookingno = 100;
		int pid=102;
		String source = "chennai";
		String destination = "theni";
		String agency = "bluebirds";
		int busnumber = 103;
		String bustype = "ACSEATER";
		double amount = 300;
		int nooftickets = 5;
		double totalamount = amount * nooftickets;
		String status ="booked";
		Booking booking = new Booking(bookingno, pid,source, destination, agency, busnumber, bustype, amount, nooftickets,
				totalamount, status);
		BookingService bookingservice = new BookingService();
		bookingservice.addReservation(booking);
		System.out.println(booking);

	}

}
