package in.poovi.model.service;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.BusDetailsDao;
import in.poovi.exception.DBException;
import in.poovi.exception.ServiceException;
import in.poovi.exception.ValidationException;
import in.poovi.model.BusDetails;

public class BusDetailsService {

	public static final List<BusDetails> busList = new ArrayList<>();

	static BusDetailsDao busdetailsdao = new BusDetailsDao();

	/**
	 * This method is used to display the all bus details
	 * 
	 * @return allbusdetails
	 * @throws DBException 
	 */
	public List<BusDetails> getBusDetails() throws DBException {
		return busdetailsdao.findAllBusDetails();
	}

	/**
	 * This method is used to add the bus details
	 * 
	 * @param bus
	 * @throws ServiceException 
	 */
	public void addBusDetails(BusDetails bus) throws ServiceException {
		if (bus.getSource().equals(bus.getDestination())) {
			throw new ServiceException("both source and destination same we cannot booking");
		}

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

	/**
	 * This method is used to get no of buses....
	 * 
	 * @return noofBuses
	 * @throws Exception
	 */
	int noOfBuses() throws Exception {
		return busdetailsdao.noOfBuses();
	}

	/**
	 * This method is used to list the stationdetails....
	 * 
	 * @param source
	 * @param destination
	 * @return stationlist
	 * @throws ServiceException
	 * @throws ValidationException 
	 */
	public List<BusDetails> findStationList(String source, String destination) throws ServiceException, ValidationException {

		List<BusDetails> stationlist;
		try {
			validateSearch(source, destination);
			stationlist = busdetailsdao.findStationList(source, destination);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException("unable to display");
		}
		return stationlist;
	}

	/**
	 * This method is used to validate the source and destination....
	 * 
	 * @param busSource
	 * @param busDestination
	 * @throws ValidatorException
	 */
	public void validateSearch(String busSource, String busDestination) throws ValidationException {
		if (busSource == null || busSource.equals("") || busSource.trim().equals("")) {
			throw new ValidationException("Invalid Source");
		}
		if (busDestination == null) {
			throw new ValidationException("Invalid destination");
		}
	}

}
