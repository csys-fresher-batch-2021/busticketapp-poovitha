 package in.poovi.model.service;

import java.util.ArrayList;

import java.util.List;

import in.poovi.dao.BusDetailsDao;
import in.poovi.model.BusDetails;

public class BusDetailsService {

	public static final List<BusDetails> busList=new ArrayList<>();
	static BusDetailsDao busdetailsdao = new BusDetailsDao();

	public List<BusDetails> getBusDetails() {
		return busdetailsdao.allBusDetails();
	}

	public void addBusList(BusDetails bus) {
		busdetailsdao.save(bus);
	}

	public static void deletebus(String agency) {

		busdetailsdao.deletebus(agency);

	}
}
