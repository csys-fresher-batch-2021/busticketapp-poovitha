package in.poovi.model.service;

import java.util.ArrayList;
import java.util.List;

import in.poovi.model.MyList;

public class Display {
	private Display() {

	}

	private static final List<MyList> list = new ArrayList<>();
	static {
		list.add(new MyList("chennai", "madurai"));
		list.add(new MyList("chennai", "theni"));
		list.add(new MyList("madurai", "dindugal"));
		list.add(new MyList("theni", "madurai"));
		list.add(new MyList("kovai", "chennai"));

	}

	public static List<MyList> getList() {
		return list;
	}

	public static boolean addList(String from, String to) {
		boolean isAdded = false;
		list.add(new MyList(from, to));
		// list.add(to);
		isAdded = true;
		return isAdded;
	}

}
