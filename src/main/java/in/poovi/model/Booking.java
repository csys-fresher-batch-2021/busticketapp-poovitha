package in.poovi.model;

public class Booking {

	private int bookingNo;
	private String source;
	private String destination;
	private String agency;
	private int busnumber;
	private String busType;
	private double amount;
	private int noOfTickets;
	private double totalAmount;
	private String status="BOOKING";

	public Booking() {
		super();
	}

	public Booking(int bookingNo, String source, String destination, String agency, int busnumber, String busType,
			double amount, int noOfTickets, double totalAmount, String status) {
		super();
		this.bookingNo = bookingNo;
		this.source = source;
		this.destination = destination;
		this.agency = agency;
		this.busnumber = busnumber;
		this.busType = busType;
		this.amount = amount;
		this.noOfTickets = noOfTickets;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	public int getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
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

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Booking [bookingNo=" + bookingNo + ", source=" + source + ", destination=" + destination + ", agency="
				+ agency + ", busnumber=" + busnumber + ", busType=" + busType + ", amount=" + amount + ", noOfTickets="
				+ noOfTickets + ", totalAmount=" + totalAmount + ", status=" + status + "]";
	}

}
