package in.poovi.dao;

import java.util.List;

import in.poovi.exception.DBException;
import in.poovi.model.PassengerModel;

public interface PassengerListDAO {

	/**
	 * This method is used to display the passenger list.....
	 * 
	 * @return busRoute
	 * @throws DBException
	 */
	List<PassengerModel> findAll() throws DBException;

	/**
	 * used to add the passenger details from the list......
	 * 
	 * @param busRoute
	 * @throws DBException
	 */
	void savePassenger(PassengerModel passengermodel) throws DBException;

	/**
	 * delete the passenger from the list......
	 * 
	 * @param pid
	 * @throws DBException
	 */
	void deletePassenger(int pid) throws DBException;

	/**
	 * This method is used to update the mobileno ......
	 * 
	 * @param mobileno
	 * @param pname
	 * @throws DBException 
	 */
	void updateMobileno(long mobileno, String pname) throws DBException;

}