package in.poovi.model;

public class BusDetails {
public BusDetails() {
		super();
	}
private String agency;	
 private int busnumber;
 private String busType;
 private double amount;
 //private LocalTime departureTime;
 //private LocalTime arrivalTime;

 public BusDetails(String agency, int busnumber, String busType, double amount) {
	super();
	this.agency = agency;
	this.busnumber = busnumber;
	this.busType = busType;
	this.amount = amount;
	//this.departureTime = departureTime;
	//this.arrivalTime = arrivalTime;
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
/**public LocalTime getDepartureTime() {
	return departureTime;
}
public void setDepartureTime(LocalTime departureTime) {
	this.departureTime = departureTime;
}
public LocalTime getArrivalTime() {
	return arrivalTime;
}
public void setArrivalTime(LocalTime arrivalTime) {
	this.arrivalTime = arrivalTime;
}*/
@Override
public String toString() {
	return "BusDetails [agency=" + agency + ", busnumber=" + busnumber + ", busType=" + busType + ", amount=" + amount
			 + "]";
}

	
}
