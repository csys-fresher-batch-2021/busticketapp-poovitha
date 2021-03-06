package in.poovi.dao;

import java.util.List;
import java.util.Map;

import in.poovi.exception.DBException;
import in.poovi.model.BusDetails;

public interface BusDetailsDAO {

	/**
	 * This method is used to list the all busdetails
	 * 
	 * @return busdetails
	 * @throws DBException 
	 */

	List<BusDetails> findAll() throws DBException;

	/**
	 * This method is used to add the busdetails in database
	 * 
	 * @param busdetails
	 * @throws DBException
	 */
	void save(BusDetails busdetails) throws DBException;

	/**
	 * This method is used to delete the busdetails in database
	 * 
	 * @param agency
	 * @throws DBException 
	 */
	void deleteBus(int bno) throws DBException;

	/**
	 * This method is used to count the Number of buses.....
	 * 
	 * @return usercount
	 * @throws Exception
	 */
	int noOfBuses() throws DBException;

	/**
	 * This method is used to list the number of buslist......
	 * 
	 * @return obj
	 * @throws Exception
	 */
	Map<String, Integer> noOfBuslist() throws DBException;

	/**
	 * This method is used to display the stationlist.....
	 * 
	 * @param source
	 * @param destination
	 * @return stationlist
	 * @throws DBException
	 */
	List<BusDetails> findStationList(String source, String destination) throws DBException;

}