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

		String agency = "makemytrip bus";
		int busnumber = 102;
		String bustype = "AcSleeper";
		String destination = "madurai";
		String source = "chennai";
		double amount = 400;
		BusDetails busdetails = new BusDetails(agency, busnumber, bustype, source,destination, amount);
		// BusDetailsService busdetailsservice = new BusDetailsService();
		// busdetailsservice.addBusDetails(busdetails);
		BusDetailsDao busdetailsdao = new BusDetailsDao();
		busdetailsdao.save(busdetails);
		System.out.println(busdetails);

	}

}
