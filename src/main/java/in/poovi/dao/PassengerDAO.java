package in.poovi.dao;

import java.util.ArrayList;
import java.util.List;
import in.poovi.model.PassengerModel;

public class PassengerDAO {
	public static final List<PassengerModel> passengermodel = new ArrayList<>();

	
	public static final String FEMALE="F";
	public static final String MALE="M";



	static {
		passengermodel.add(new PassengerModel("poovi",101, 20, FEMALE, 9876987608L));
		passengermodel.add(new PassengerModel("yamini", 102,22, FEMALE, 9999999999L));
	}

	private static List<PassengerModel> name = new ArrayList<>();

	public void addpassenger(String pname, int pid,int page, String gender, long mobileno) {
		passengermodel.add(new PassengerModel(pname, pid,page, gender, mobileno));
	}

	public static List<PassengerModel> allpassengerList() {
		return passengermodel;

	}
	public static List<PassengerModel> getSearch(){
		return name;
	}
  @SuppressWarnings("unlikely-arg-type")
public void deletePassenger(String pname) {
	  passengermodel.remove(pname);
  }



}

