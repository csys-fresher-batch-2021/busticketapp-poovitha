package in.poovi.model;

public class PassengerModel {

	//private int busNo;
	private String passengername;
	private int passengerId;
	private String passengerGender;
	private int passengerAge;
	private long mobileNumber;
	
	public String getPassengername() {
		return passengername;
	}
	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}
	/*
	public int getBusNo() {
		return busNo;
	}
	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}*/
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerGender() {
		return passengerGender;
	}
	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	@Override
	public String toString() {
		return "PassengerModel [ passengername=" + passengername + ", passengerId=" + passengerId
				+ ", passengerGender=" + passengerGender + ", passengerAge=" + passengerAge + ", mobileNumber="
				+ mobileNumber + "]";
	}
}
