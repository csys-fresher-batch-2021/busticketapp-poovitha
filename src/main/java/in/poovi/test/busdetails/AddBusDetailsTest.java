package in.poovi.test.busdetails;

import in.poovi.model.BusDetails;
import in.poovi.model.service.BusDetailsService;

public class AddBusDetailsTest {

	/**
	 * This main method is used to add bus details.....
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String agency = "redbus";
		int busnumber = 103;
		String bustype = "NONAC SEATER";
		double amount = 440;
		BusDetails busdetails = new BusDetails(agency, busnumber, bustype, amount);
		BusDetailsService busdetailsservice = new BusDetailsService();
		busdetailsservice.addBusDetails(busdetails);
		System.out.println(busdetails);

	}

}
