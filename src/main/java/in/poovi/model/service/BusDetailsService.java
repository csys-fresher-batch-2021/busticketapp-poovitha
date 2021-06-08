package in.poovi.model.service;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.BusDetailsDao;
import in.poovi.model.BusDetails;

public class BusDetailsService {

	public static final List<BusDetails> busList = new ArrayList<>();

	static BusDetailsDao busdetailsdao = new BusDetailsDao();

	/**
	 * This method is used to display the all bus details
	 * 
	 * @return allbusdetails
	 */
	public List<BusDetails> getBusDetails() {
		return busdetailsdao.allBusDetails();
	}

	/**
	 * This method is used to add the bus details
	 * 
	 * @param bus
	 */
	public void addBusList(BusDetails bus) {
		busdetailsdao.save(bus);
	}

	/**
	 * This method is used to delete the bus details
	 * 
	 * @param agency
	 */
	public static void deleteBus(String agency) {

		busdetailsdao.deleteBus(agency);

	}
}
