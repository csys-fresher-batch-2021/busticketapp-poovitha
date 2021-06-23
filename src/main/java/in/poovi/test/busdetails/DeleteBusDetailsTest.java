package in.poovi.test.busdetails;

import java.util.Scanner;

import in.poovi.dao.BusDetailsDAO;

public class DeleteBusDetailsTest {
	/**
	 * This main method is used to delete the bus details...
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the delete busname:");
		String agency = sc.next();
		BusDetailsDAO busdetailsDAO = new BusDetailsDAO();
		busdetailsDAO.deleteBus(agency);
		sc.close();

	}

}
