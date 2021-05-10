package in.poovi.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Display {


		/**
		 * To add the BusRoutes.......
		 */
		static Map<Integer, String> routes = new HashMap<Integer, String>();

		public static void addBusRoutes() {
			routes.put(1, "Chennai To Madurai");
			routes.put(2, "Chennai To Trichy");
			routes.put(3, "Chennai To Theni");
			routes.put(4, "Chennai To Vilupuram");
			routes.put(5, "Chennai To Kovai");

		}

		public static void addRoute(int routeNo, String routeDetails) {
			routes.put(routeNo, routeDetails);
		}
		/**
		 * Display the available routes...... 
		 */

		public static void displayRoutes() {
			System.out.println("DISPLAY THE BUS ROUTES");
			for (Integer routeNo1 : routes.keySet()) {
				String routeDetails1 = routes.get(routeNo1);
				System.out.println("Route " + routeNo1 + ", details=" + routeDetails1);
			}
		}
	/**
	 * 
	 * @param value
	 * @return
	 */
		public static int getKeyFromValue(String value) {
			Set<Integer> keys= routes.keySet();
			int routeNum = 0;
			for (Integer routeNo : keys ) {
				String routeDetails = routes.get(routeNo);

				if (routeDetails.equalsIgnoreCase(value)) {
					routeNum = routeNo;
					break;
				}
				
			}
			return routeNum;
		}
		public static void main(String[] args) {
			int routeNo = 1;
			addBusRoutes();
			addRoute(6, "chennai to dindugal");// add the bus routes if the route is available
			displayRoutes();
			// display your booking route
			String routeDetails = routes.get(routeNo); // chennai to madurai.....
			
			System.out.println("Your route " + routeDetails);
			System.out.println(getKeyFromValue(""));

		}
	}
