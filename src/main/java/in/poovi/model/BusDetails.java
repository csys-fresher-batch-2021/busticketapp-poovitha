package in.poovi.model;

public class BusDetails {
	private String agency;
	private int busnumber;
	private String busType;
	private String source;
	private String destination;
	private double amount;
	private SeatAvailable seatavailable;

	public BusDetails() {
		super();
	}

	public BusDetails(String agency, int busnumber, String busType, String source, String destination, double amount) {
		super();
		this.agency = agency;
		this.busnumber = busnumber;
		this.busType = busType;
		this.source = source;
		this.destination = destination;
		this.amount = amount;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public int getBusnumber() {
		return busnumber;
	}

	public void setBusnumber(int busnumber) {
		this.busnumber = busnumber;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public SeatAvailable getSeatavailable() {
		return seatavailable;
	}

	public void setSeatavailable(SeatAvailable seatavailable) {
		this.seatavailable = seatavailable;
	}

	@Override
	public String toString() {
		return "BusDetails [agency=" + agency + ", busnumber=" + busnumber + ", busType=" + busType + ", source="
				+ source + ", destination=" + destination + ", amount=" + amount + ", seatavailable=" + seatavailable
				+ "]";
	}

}
