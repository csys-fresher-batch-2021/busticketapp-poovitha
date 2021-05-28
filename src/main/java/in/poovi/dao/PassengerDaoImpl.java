package in.poovi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import in.poovi.exception.DBException;
import in.poovi.model.PassengerModel;
import in.poovi.util.ConnectionUtil;

public class PassengerDaoImpl implements PassengerDAO {

	static PassengerDAO dao = new PassengerDaoImpl();

	public List<PassengerModel> getAllPassengerList() {
		Connection con = null;
	    Statement st = null;
		ResultSet rs = null;


		List<PassengerModel> passengermodel = new ArrayList<>();
		try {
			// getting the connection
			con = ConnectionUtil.getConnection();

			st = con.createStatement();
			rs = st.executeQuery("select * from productInfo");

			while (rs.next()) {
				int passengerid = rs.getInt("passengerId");
                String passengername = rs.getString("passengername");
				String passengergender = rs.getString("PassengerGender");
				// busNo=rs.getInt("busNo");
				int passengerage = rs.getInt("passengerage");
				long passengermobilenumber = rs.getInt("mobilenumber");
				PassengerModel passenger = new PassengerModel();
				passenger.setPassengername(passengername);
				passenger.setPassengerGender(passengergender);
				// passenger.setBusNo(busNo);
				passenger.setPassengerAge(passengerage);
				passenger.setMobileNumber(passengermobilenumber);
				passenger.setPassengerId(passengerid);
				// getting the values in ArrayList
				passengermodel.add(passenger);
				//ConnectionUtil.close(rs, st, con);

			}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		// closing the connection
		ConnectionUtil.close(con,st,rs);
		
	}



		return passengermodel;

	}

public void addPassengerList(PassengerModel obj) throws Exception {
try {
	Connection connection = ConnectionUtil.getConnection();
    String sql="insert into passengerList (passengerid,passengername,passengergender,passengerage,passengermobilenumber)values(?,?,?,?,?)";
    PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1,obj.getPassengername());
        pst.setString(2,obj.getPassengerGender());
        pst.setInt(3,obj.getPassengerAge());
        pst.setLong(4,obj.getMobileNumber());
        pst.setInt(5,obj.getPassengerId());
        pst.executeUpdate(sql);
	ConnectionUtil.close(pst, connection);
	}catch(SQLException e) {
		e.printStackTrace();
		throw new DBException("Unable to Add passenger");

	}
}	
}
/*
	@Override
	public void deletePassengerList(int passengerId) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatepassengerList(long mobileNumber, int passengerId) throws Exception {
		// TODO Auto-generated method stub

	}

}*/
