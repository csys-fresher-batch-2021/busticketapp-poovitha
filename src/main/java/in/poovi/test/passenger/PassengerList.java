package in.poovi.test.passenger;

import java.util.List;

import in.poovi.dao.PassengerListDAO;
import in.poovi.dao.impl.PassengerListDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.logger.Logger;
import in.poovi.model.PassengerModel;

public class PassengerList {

	/**
	 * This main method is used to list the all passenger list
	 * 
	 * @param args
	 * @throws DBException 
	 */
	public static void main(String[] args) throws DBException {

		PassengerListDAO passengerlistDAO = new PassengerListDAOImpl();
		List<PassengerModel> passenger = passengerlistDAO.findAll();
		Logger.info(passenger);

	}

}
