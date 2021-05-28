package in.poovi.dao;

import java.util.List;

//import in.poovi.exception.DBException;
import in.poovi.model.PassengerModel;

public interface PassengerDAO {
   List<PassengerModel> getAllPassengerList();
   public void addPassengerList(PassengerModel obj) throws Exception;

}
