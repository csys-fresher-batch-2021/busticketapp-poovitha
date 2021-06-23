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

		String agency = "jai travels";
		int busnumber = 106;
		String bustype = "AcSleeper";
		String destination = "theni";
		String source = "trichy";
		double amount = 300;
		BusDetails busdetails = new BusDetails(agency, busnumber, bustype, source,destination, amount);
		// BusDetailsService busdetailsservice = new BusDetailsService();
		// busdetailsservice.addBusDetails(busdetails);
		BusDetailsDao busdetailsdao = new BusDetailsDao();
		busdetailsdao.save(busdetails);
		System.out.println(busdetails);

	}

}
