package in.poovi.service;

import java.util.ArrayList;
import java.util.List;

import in.poovi.dao.BusRouteDAO;
import in.poovi.exception.DBException;
import in.poovi.exception.ServiceException;
import in.poovi.model.BusRoute;

public class BusRouteService {

	public static final List<BusRoute> busroute = new ArrayList<>();

	static BusRouteDAO busrouteDAO = new BusRouteDAO();

	/**
	 * This method is used to display the all routes....
	 * 
	 * @return findAllBusRoute
	 * @throws DBException
	 */
	public static List<BusRoute> getBusRoute() throws DBException {
		return busrouteDAO.findAll();
	}

	/**
	 * This method is used to add the busroute......
	 * 
	 * @param busRoute
	 * @throws DBException
	 * @throws ServiceException
	 */
	public void addRouteList(BusRoute busRoute) throws DBException, ServiceException {
		if (busRoute.getSource().equals(busRoute.getDestination())) {
			throw new ServiceException("both source and destination same we cannot booking");
		}
		busrouteDAO.save(busRoute);
	}

	/**
	 * This method is used to delete the busroute
	 * 
	 * @param routeno
	 * @throws DBException
	 */
	public static void deleteRoute(int routeno) throws DBException {
		busrouteDAO.deleteRoute(routeno);
	}

}
