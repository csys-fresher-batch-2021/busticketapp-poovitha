package in.poovi.test.busdetails;

import in.poovi.dao.BusDetailsDao;
import in.poovi.model.BusDetails;

public class AddBusDetailsTest {

	/**
	 * This main method is used to add bus details.....
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String agency = "sri travels";
		int busnumber = 103;
		String bustype = "Sleeper";
		String destination = "thenii";
		String source = "kovai";
		double amount = 300;
		BusDetails busdetails = new BusDetails(agency, busnumber, bustype, source,destination, amount);
		// BusDetailsService busdetailsservice = new BusDetailsService();
		// busdetailsservice.addBusDetails(busdetails);
		BusDetailsDao busdetailsdao = new BusDetailsDao();
		busdetailsdao.save(busdetails);
		System.out.println(busdetails);

	}

}
