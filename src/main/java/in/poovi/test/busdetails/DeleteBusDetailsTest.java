package in.poovi.test.busdetails;

import java.util.Scanner;

import in.poovi.dao.BusDetailsDao;

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
		BusDetailsDao busdetailsdao = new BusDetailsDao();
		busdetailsdao.deleteBus(agency);
		sc.close();

	}

}
