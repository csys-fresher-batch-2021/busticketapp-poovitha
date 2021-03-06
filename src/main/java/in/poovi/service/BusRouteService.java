package in.poovi.service;

import java.util.List;

import in.poovi.dao.impl.BusRouteDAOImpl;
import in.poovi.exception.DBException;
import in.poovi.exception.ServiceException;
import in.poovi.model.BusRoute;

public class BusRouteService {

	private static BusRouteDAOImpl busrouteDAO = new BusRouteDAOImpl();

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
