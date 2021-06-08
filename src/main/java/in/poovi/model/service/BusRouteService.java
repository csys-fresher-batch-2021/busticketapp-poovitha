package in.poovi.model.service;

import java.util.ArrayList;
import java.util.List;

import in.poovi.model.BusRoute;

public class BusRouteService {
	private BusRouteService() {

	}

	private static final List<BusRoute> list = new ArrayList<>();
	static {
		list.add(new BusRoute("chennai", "madurai"));
		list.add(new BusRoute("chennai", "theni"));
		list.add(new BusRoute("madurai", "dindugal"));
		list.add(new BusRoute("theni", "madurai"));
		list.add(new BusRoute("kovai", "chennai"));

	}

	/**
	 * This method is used to get all busroutes....
	 * 
	 * @return list
	 */
	public static List<BusRoute> getList() {
		return list;
	}

	/**
	 * This method is used to add the busroute.....
	 * 
	 * @param from
	 * @param to
	 * @return isAdded
	 */
	public static boolean addList(String from, String to) {
		boolean isAdded = false;
		list.add(new BusRoute(from, to));
		isAdded = true;
		return isAdded;
	}

}
