package in.poovi.model.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

//import in.poovi.exception.DBException;
import in.poovi.model.PassengerModel;
import in.poovi.model.service.PassengerService;

/**
 * Servlet implementation class PassengerListServlet
 */
@WebServlet("/PassengerListServlet")
public class PassengerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassengerListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    
		List<PassengerModel> passenger=PassengerService.getAllPassengerListDB();
		Gson gson = new Gson();
		// converting the list to json
		String json = gson.toJson(passenger);
		// writting JSon response
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();

		
	}


}
