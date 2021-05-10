package in.name.testcase;

import static org.junit.Assert.*;

import org.junit.Test;

import in.poovi.service.Display;

public class BusRouteTest {




			
			@Test
			public void testcase1() {

				Display.addRoute(6,"chennai to nellai");
			}
			@Test
			public void testcase2() {

				Display.displayRoutes();
			}
			@Test
			public void testcase3() {
				Display.addBusRoutes();
		        String busRoute = "ChennaiToMadurai";
				int results = Display.getKeyFromValue(busRoute);
				assertEquals(1,results);

				
		      }
			
		}

	


