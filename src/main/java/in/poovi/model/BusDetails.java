package in.poovi.model;

public class BusDetails {
	private String agency;
	private int busnumber;
	private String busType;
	private double amount;

	public BusDetails() {
		super();
	}

	public BusDetails(String agency, int busnumber, String busType, double amount) {
		super();
		this.agency = agency;
		this.busnumber = busnumber;
		this.busType = busType;
		this.amount = amount;
	}

	public int getBusnumber() {
		return busnumber;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
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

	@Override
	public String toString() {
		return "BusDetails [agency=" + agency + ", busnumber=" + busnumber + ", busType=" + busType + ", amount="
				+ amount + "]";
	}

}
