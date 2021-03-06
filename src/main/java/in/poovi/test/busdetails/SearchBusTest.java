package in.poovi.test.busdetails;

import java.util.List;

import in.poovi.dao.BusDetailsDAO;
import in.poovi.dao.impl.BusDetailsDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.logger.Logger;
import in.poovi.model.BusDetails;

public class SearchBusTest {

	/**
	 * This method is used to display the station details.....
	 * 
	 * @param args
	 * @throws DBException
	 */
	public static void main(String[] args) throws DBException {
		BusDetailsDAO busdetailDAO = new BusDetailsDAOImpl();
		String source = "madurai";
		String destination = "chennai";
		List<BusDetails> bus =busdetailDAO.findStationList(source, destination);
		Logger.info(bus.size());
		for (BusDetails test : bus) {
			Logger.info(
					test.getAgency() + "\t" + test.getBusnumber() + "\t" + test.getBusType() + "\t" + test.getSource()
							+ "\t" + test.getDestination() + "\t" + test.getSeatavailable() + "\t" + test.getAmount());
		}
	}

}
