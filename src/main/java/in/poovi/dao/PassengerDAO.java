package in.poovi.dao;

import java.util.ArrayList;
import java.util.List;
import in.poovi.model.PassengerModel;

public class PassengerDAO {
	public static List<PassengerModel> passengermodel = new ArrayList<>();

	static {
		passengermodel.add(new PassengerModel(101, "poovi", 20, "female", 9876987608L));
		passengermodel.add(new PassengerModel(102, "yamini", 22, "female", 9999999999L));
	}

	private static List<PassengerModel> name = new ArrayList<>();

	public void addpassenger(int pid, String pname, int page, String gender, long mobileno) {
		passengermodel.add(new PassengerModel(pid, pname, page, gender, mobileno));
	}

	public static List<PassengerModel> allpassengerList() {
		return passengermodel;

	}
	public void addSearchbyname(int pid1,String pname1,int page1,String gender1,long mobileno1) {
		name.add(new PassengerModel(pid1,pname1,page1,gender1,mobileno1));
	}
	public static List<PassengerModel> getSearch(){
		return name;
	}
}
