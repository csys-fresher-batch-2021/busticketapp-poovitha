package in.poovi.model.service;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.SeatAvailableDao;
import in.poovi.model.Booking;
import in.poovi.model.SeatAvailable;

public class SeatAvailableService {
	public static final List<SeatAvailable> seatavailable = new ArrayList<>();

	static SeatAvailableDao seatavailabledao = new SeatAvailableDao();

	/**
	 * This method is used to display the all available seat.....
	 * 
	 * @return allAvailableSeat
	 * @throws Exception
	 */

	public List<SeatAvailable> getallavailableSeat() throws Exception {
		return seatavailabledao.allAvailableSeat();
	}

	/**
	 * This method is used to add the seat available in the available bus.......
	 * 
	 * @param seatavailable
	 * @throws Exception
	 */
	public void saveSeat(SeatAvailable seatavailable) throws Exception {
		seatavailabledao.saveSeat(seatavailable);
	}

	/**
	 * This method is used to delete the seat if the bus is not available.....
	 * 
	 * @param busnumber
	 */
	public void deleteSeat(int busnumber) {
		seatavailabledao.deleteSeat(busnumber);
	}

	/**
	 * This method is used to update seat available
	 * 
	 * @param busnumber
	 * @param availableseat
	 */
	public void UpdateSeat(int busnumber, int availableseat) {
		seatavailabledao.updateSeat(busnumber, availableseat);
	}

	/**
	 * This method is used to get available seat
	 * 
	 * @param busnumber
	 * @return availableseat
	 */

	public int seatDetails(int busnumber) {
		int availableSeats = 0;
		try {
			availableSeats = seatavailabledao.seatDetails(busnumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return availableSeats;
	}

	/**
	 * This method is used to update the available seat after the ticket
	 * booked......
	 * 
	 * @param busnumber
	 * @param availableseat
	 */
	public void UpdateSeatAvailable(int busnumber) {
		busnumber = SeatAvailableService.availableseat(busnumber);
		seatavailabledao.updateSeatAvailable(busnumber);
	}

	/**
	 * This method is used to get the availableseat
	 * 
	 * @param busnumber
	 * @return availableseat
	 */
	public static int availableseat(int busnumber) {
		int availableseat = 0;
		Booking booking = new Booking();
		try {
			availableseat = availableseat - booking.getNoOfTickets();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return availableseat;
	}
}
