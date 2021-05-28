package in.poovi.model.service;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.PassengerDAO;
import in.poovi.dao.PassengerDaoImpl;

import in.poovi.model.PassengerModel;

public class PassengerService {
	private PassengerService() {

	}

	private static PassengerDAO dao = new PassengerDaoImpl();

	public static List<PassengerModel> getAllPassengerListDB() {

		List<PassengerModel> passenger = dao.getAllPassengerList();
		List<PassengerModel> passengers = new ArrayList<>(passenger);
		return passengers;
	}

	public void addPassengerList(PassengerModel obj) throws Exception {
		dao.addPassengerList(obj);

	}
}
