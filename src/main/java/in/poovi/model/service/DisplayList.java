package in.poovi.model.service;

//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.List;

public class DisplayList {

	private DisplayList() {
		// private constructor to avoid object creation
	}

	static HashMap<String, String> hashMap = new HashMap<>();
	static {

		hashMap.put("CHENNAI", "MADURAI");
		hashMap.put("MADURAI", "CHENNAI");
		hashMap.put("NELLAI", "KOVAI");
		hashMap.put("KOVAI", "NELLAI");
		hashMap.put("THIRCHY","CHENNAI");
		hashMap.put("DINDUGAL","THIRCHY");
		hashMap.put("THENI","DINDUGAL");
		hashMap.put("KARUR","MADURAI");
		//for(String from1:hashMap.keySet()) {
			//String to1=hashMap.get(from1);
			//System.out.println("FROM : " + from1 + " TO : " + to1);
		//}


	}
	public static HashMap<String,String> getList(){
		return hashMap;
	}
	public static boolean addList(String from,String to) {
        boolean isAdded=false;
		hashMap.put(from,to);
		for(String from1:hashMap.keySet()) {
			String to1=hashMap.get(from1);
			System.out.println("FROM : " + from1 + " TO : " + to1);
		}
		if(isAdded) {
               return true;
				
			}
		
		return isAdded;

        //for(String key:hashMap.keySet()){
        //	String to1=hashMap.get(key);
           

        
	}

}
