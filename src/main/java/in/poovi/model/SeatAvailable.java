package in.poovi.model;

import java.time.LocalDateTime;

public class SeatAvailable {

	private int busnumber;
	private int availableSeat;
	private int totalSeat;
	private LocalDateTime availableDate;
	private Booking booking;

	public SeatAvailable() {
		super();
	}

	public SeatAvailable(int busnumber, int availableSeat, int totalSeat, LocalDateTime availableDate) {
		super();
		this.busnumber = busnumber;
		this.availableSeat = availableSeat;
		this.totalSeat = totalSeat;
		this.availableDate = availableDate;
	}

	public int getBusnumber() {
		return busnumber;
	}

	public void setBusnumber(int busnumber) {
		this.busnumber = busnumber;
	}

	public int getAvailableSeat() {
		return availableSeat;
	}

	public void setAvailableSeat(int availableSeat) {
		this.availableSeat = availableSeat;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public LocalDateTime getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(LocalDateTime availableDate) {
		this.availableDate = availableDate;
	}

	@Override
	public String toString() {
		return "SeatAvailable [busnumber=" + busnumber + ", availableSeat=" + availableSeat + ", totalSeat=" + totalSeat
				+ ", availableDate=" + availableDate + ", booking=" + booking + "]";
	}

}
