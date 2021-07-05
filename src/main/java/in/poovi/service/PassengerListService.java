package in.poovi.service;

import java.util.List;

import in.poovi.dao.PassengerListDAO;
import in.poovi.dao.impl.PassengerListDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.exception.ServiceException;
import in.poovi.message.MessageConstants;
import in.poovi.model.PassengerModel;

public class PassengerListService {

	private static PassengerListDAO passengerlistdao = new PassengerListDAOImpl();

	/**
	 * This method is used to list the all passenger details....
	 * 
	 * @return all passengerlist
	 * @throws DBException 
	 */
	public static List<PassengerModel> getPassengerList() throws DBException {
		return passengerlistdao.findAll();
	}

	/**
	 * This method is used to add the passenger in the list....
	 * 
	 * @param passengermodel
	 * @throws ServiceException 
	 * @throws DBException 
	 */
	public void addPassenger(PassengerModel passengermodel) throws ServiceException, DBException {
		if(passengermodel.getPname()==null || "".equals(passengermodel.getPname().trim()) || passengermodel.getPname().length()<4){
			throw new ServiceException(MessageConstants.INVALID_NAME);
		}
		passengerlistdao.savePassenger(passengermodel);
	}

	/**
	 * This method is used to delete the passenger from the list
	 * 
	 * @param pid
	 * @throws DBException
	 */
	public static void deletePassenger(int pid) throws DBException {
		passengerlistdao.deletePassenger(pid);

	}

}
