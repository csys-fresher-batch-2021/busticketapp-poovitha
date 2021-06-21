package in.poovi.test.busdetails;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.BusDetailsDao;
import in.poovi.exception.DBException;
import in.poovi.model.BusDetails;

public class SearchBusTest {

	/**
	 * This method is used to display the station details.....
	 * 
	 * @param args
	 * @throws DBException
	 */
	public static void main(String[] args) throws DBException {
		BusDetailsDao busdetaildao = new BusDetailsDao();
		String source = "chennai";
		String destination = "theni";
		List<BusDetails> bus = new ArrayList<>();
		bus = busdetaildao.stationList(source, destination);
		for (BusDetails test : bus) {

			System.out.println(
					test.getAgency() + "\t" + test.getBusnumber() + "\t" + test.getBusType() + "\t" + test.getSource()
							+ "\t" + test.getDestination() + "\t" + test.getSeatavailable() + "\t" + test.getAmount());
			System.out.println();
		}
		// System.out.println(bus);
	}

}
