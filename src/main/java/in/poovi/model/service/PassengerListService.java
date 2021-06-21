package in.poovi.model.service;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.PassengerListDao;
import in.poovi.exception.ServiceException;
import in.poovi.message.MessageConstants;
import in.poovi.model.PassengerModel;

public class PassengerListService {

	public static final List<PassengerModel> passengerlist = new ArrayList<>();

	static PassengerListDao passengerlistdao = new PassengerListDao();

	/**
	 * This method is used to list the all passenger details....
	 * 
	 * @return all passengerlist
	 */
	public static List<PassengerModel> getPassengerList() {
		return passengerlistdao.allPassengerList();
	}

	/**
	 * This method is used to add the passenger in the list....
	 * 
	 * @param passengermodel
	 * @throws ServiceException 
	 */
	public void addPassenger(PassengerModel passengermodel) throws ServiceException {
		if(passengermodel.getPname()==null || "".equals(passengermodel.getPname().trim()) || passengermodel.getPname().length()<4){
			throw new ServiceException(MessageConstants.INVALID_NAME);
		}
		passengerlistdao.savePassenger(passengermodel);
	}

	/**
	 * This method is used to delete the passenger from the list
	 * 
	 * @param pid
	 */
	public static void deletePassenger(int pid) {
		passengerlistdao.deletePassenger(pid);

	}

}
