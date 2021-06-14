package in.poovi.model;

public class SeatAvailable {

	private int busnumber;
	private int availableSeat; 
	private int totalSeat;
	
	public SeatAvailable() {
		super();
	}

	public SeatAvailable(int busnumber, int availableSeat, int totalSeat) {
		super();
		this.busnumber = busnumber;
		this.availableSeat = availableSeat;
		this.totalSeat = totalSeat;
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

	@Override
	public String toString() {
		return "SeatAvailable [busnumber=" + busnumber + ", availableSeat=" + availableSeat + ", totalSeat=" + totalSeat
				+ "]";
	}
	 
	
}
