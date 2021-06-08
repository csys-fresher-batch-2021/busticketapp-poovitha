package in.poovi.test;

import java.util.Scanner;

import in.poovi.dao.BusDetailsDao;

public class TestDeleteBusList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the delete busname:");
		String agency = sc.next();
		BusDetailsDao busdetailsdao = new BusDetailsDao();
		busdetailsdao.deleteBus(agency);
		sc.close();

	}

}
