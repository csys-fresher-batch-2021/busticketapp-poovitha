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

		String agency = "redbus";
		int busnumber = 100;
		String bustype = "AcSleeper";
		String source = "chennai";
		String destination = "theni";
		double amount = 440;
		BusDetails busdetails = new BusDetails(agency, busnumber, bustype, destination, source, amount);
		// BusDetailsService busdetailsservice = new BusDetailsService();
		// busdetailsservice.addBusDetails(busdetails);
		BusDetailsDao busdetailsdao = new BusDetailsDao();
		busdetailsdao.save(busdetails);
		System.out.println(busdetails);

	}

}
