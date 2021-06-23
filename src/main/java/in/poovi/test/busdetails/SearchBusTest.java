package in.poovi.test.busdetails;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.BusDetailsDAO;
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
		BusDetailsDAO busdetailDAO = new BusDetailsDAO();
		String source = "kovai";
		String destination = "thenii";
		List<BusDetails> bus = new ArrayList<>();
		bus = busdetailDAO.findStationList(source, destination);
		System.out.println(bus.size());
		for (BusDetails test : bus) {
			System.out.println(
					test.getAgency() + "\t" + test.getBusnumber() + "\t" + test.getBusType() + "\t" + test.getSource()
							+ "\t" + test.getDestination() + "\t" + test.getSeatavailable() + "\t" + test.getAmount());
		}
	}

}
