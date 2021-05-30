package in.poovi.model.service;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.PassengerDAO;
//import in.poovi.dao.PassengerDaoImpl;

import in.poovi.model.PassengerModel;

public class PassengerService {
	
private PassengerService()
{
	
}
	
public static PassengerDAO passengerdao=new PassengerDAO();

public static boolean addpassenger(int pid, String name, int page, String pgender,long pmobileno) {
	boolean isAdded = false;
	boolean present = PassengerService.isPresent(name);

	if (!present) {
		isAdded = true;
		passengerdao.addpassenger(pid,name, page, pgender, pmobileno);
	}

	return isAdded;
}

private static boolean isPresent(String name) {
	
	
		boolean present = false;
		List<PassengerModel> passengers = PassengerDAO.allpassengerList();
		for (PassengerModel passengermodel : passengers) {
			if (passengermodel.getPname().equalsIgnoreCase(name)) {
				present = true;
			}

		}
		return present;

	}




	
}
