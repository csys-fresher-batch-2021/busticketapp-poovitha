 package in.poovi.model.service.servlet;

import java.io.IOException;
//import java.sql.Time;
import java.time.LocalTime;
//import java.util.List;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.poovi.model.BusDetails;
import in.poovi.model.service.BusDetailsService;

/**
 * Servlet implementation class BusListServlet
 */
@WebServlet("/BusListServlet")
public class BusListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BusListServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

			String agency = request.getParameter("agency");
			System.out.println(agency+ agency.length());
			int busno = Integer.parseInt(request.getParameter("b_no"));
			String bustype = request.getParameter("bustype");
			double amount = Integer.parseInt(request.getParameter("amount"));
			// LocalTime
			//List<BusDetails> busdetails = BusDetailsService.getBusDetails();
            // deparaturetime=LocalTime.parse(request.getParameter("departuretime"));
			// LocalTime arrivaltime=LocalTime.parse(request.getParameter("arrivaltime"));
			try {
	     	BusDetails bus = new BusDetails(agency, busno, bustype, amount);
			BusDetailsService busdetailsservice = new BusDetailsService();
			busdetailsservice.addBusList(bus);

			String message = "added";
			response.sendRedirect("BusList.jsp?infomessage=" + message);

			// response.sendRedirect("addBusList.jsp");

		} catch (Exception e) {
			e.printStackTrace();
			 String message="unable to add";
			response.sendRedirect("addBusList.jsp" +message);
		}

	}
}