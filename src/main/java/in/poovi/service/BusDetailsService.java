package in.poovi.service;

import java.util.List;
import java.util.Map;

import in.poovi.dao.BusDetailsDAO;
import in.poovi.dao.impl.BusDetailsDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.exception.ServiceException;
import in.poovi.exception.ValidationException;
import in.poovi.model.BusDetails;
import sun.security.validator.ValidatorException;

public class BusDetailsService {

	private static BusDetailsDAO busdetailsDAO = new BusDetailsDAOImpl();

	/**
	 * This method is used to display the all bus details
	 * 
	 * @return allbusdetails
	 * @throws DBException
	 */
	public List<BusDetails> getBusDetails() throws DBException {
		return busdetailsDAO.findAll();
	}

	/**
	 * This method is used to add the bus details
	 * 
	 * @param bus
	 * @throws ServiceException
	 * @throws DBException
	 */
	public void addBusDetails(BusDetails bus) throws ServiceException, DBException {
		if (bus.getSource().equals(bus.getDestination())) {
			throw new ServiceException("both source and destination same we cannot booking");
		}
		busdetailsDAO.save(bus);
	}

	/**
	 * This method is used to delete the bus details
	 * 
	 * @param busnumber
	 * @throws DBException 
	 */
	public static void deleteBus(int busnumber) throws DBException{

		busdetailsDAO.deleteBus(busnumber);

	}

	/**
	 * This method is used to get no of buses....
	 * 
	 * @return noofBuses
	 * @throws Exception
	 */
	int noOfBuses() throws DBException {
		return busdetailsDAO.noOfBuses();
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
	public List<BusDetails> findStationList(String source, String destination)
			throws ServiceException, ValidationException {

		List<BusDetails> stationlist;
		try {
			validateSearch(source, destination);
			stationlist = busdetailsDAO.findStationList(source, destination);
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

	/**
	 * This method is used to display the number of buses available
	 * 
	 * @return
	 * @throws Exception
	 */
	public Map<String, Integer> noOfBuslist() throws DBException {
		return busdetailsDAO.noOfBuslist();
	}

}
