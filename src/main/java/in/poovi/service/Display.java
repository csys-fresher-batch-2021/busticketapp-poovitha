package in.poovi.service;

import java.util.ArrayList;
import java.util.List;

import in.poovi.exception.ServiceException;
import in.poovi.model.MyList;

public class Display {
	private Display() {

	}

	private static final List<MyList> list = new ArrayList<>();
	static {
		list.add(new MyList("chennai", "madurai"));
		list.add(new MyList("karur", "theni"));
		list.add(new MyList("thirchy", "dindugal"));
		list.add(new MyList("theni", "nellai"));
		list.add(new MyList("kovai", "virudunagar"));

	}

	public static List<MyList> getList() {
		return list;
	}

	public static boolean addList(String from, String to) throws ServiceException{
		boolean isAdded = false;
		list.add(new MyList(from, to));
		isAdded = true;
		return isAdded;
	}

}
