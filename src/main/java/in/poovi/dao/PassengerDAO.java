package in.poovi.dao;

import java.util.ArrayList;
import java.util.List;

import in.poovi.model.PassengerModel;

public class PassengerDAO {
	public static final List<PassengerModel> passengermodel = new ArrayList<>();

	public static final String FEMALE = "F";
	public static final String MALE = "M";

	static {
		passengermodel.add(new PassengerModel("poovi", 101, 20, FEMALE, 9876987608L));
		passengermodel.add(new PassengerModel("yamini", 102, 22, FEMALE, 9999999999L));
	}

	private static List<PassengerModel> name = new ArrayList<>();

	/**
	 * This method is used to add the passenger details....
	 * 
	 * @param pname
	 * @param pid
	 * @param page
	 * @param gender
	 * @param mobileno
	 */
	public void addpassenger(String pname, int pid, int page, String gender, long mobileno) {
		passengermodel.add(new PassengerModel(pname, pid, page, gender, mobileno));
	}

	/**
	 * This method is used to list all the passenger details.....
	 * 
	 * @return passengermodel
	 */
	public static List<PassengerModel> allpassengerList() {
		return passengermodel;

	}

	/**
	 * This method is used to search the passenger datails by passenger name.....
	 * 
	 * @return name
	 */
	public static List<PassengerModel> getSearch() {
		return name;
	}

}