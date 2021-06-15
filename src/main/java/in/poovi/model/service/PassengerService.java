package in.poovi.model.service;

import java.util.List;

import in.poovi.dao.PassengerDao;
import in.poovi.model.PassengerModel;

public class PassengerService {

	private PassengerService() {

	}

	public static final PassengerDao passengerdao = new PassengerDao();

	/**
	 * This method is used to add the passenger......
	 * 
	 * @param pname
	 * @param pid
	 * @param page
	 * @param pgender
	 * @param pmobileno
	 * @return
	 */
	public static boolean addpassenger(String pname, int pid, int page, String pgender, long pmobileno) {
		boolean isAdded = false;
		boolean present = PassengerService.isPresent(pname);

		if (!present) {
			isAdded = true;
			passengerdao.addpassenger(pname, pid, page, pgender, pmobileno);
		}

		return isAdded;
	}

	/**
	 * This method is used to find the passenger name is already present....
	 * 
	 * @param pname
	 * @return
	 */
	private static boolean isPresent(String pname) {

		boolean present = false;
		List<PassengerModel> passengers = PassengerDao.allpassengerList();
		for (PassengerModel passengermodel : passengers) {
			if (passengermodel.getPname().equalsIgnoreCase(pname)) {
				present = true;
			}

		}
		return present;

	}

	public void deletePassenger(String pname) {
		PassengerModel searchpassenger = null;
		List<PassengerModel> passengers = PassengerDao.allpassengerList();
		for (PassengerModel passenger : passengers) {
			if (passenger.getPname().equalsIgnoreCase(pname)) {
				searchpassenger = passenger;
				break;
			}
		}

		if (searchpassenger != null) {
			passengers.remove(searchpassenger);

			System.out.println("delete");
		}
		return;
	}

}
