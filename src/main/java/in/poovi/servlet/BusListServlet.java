package in.poovi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.poovi.model.BusDetails;
import in.poovi.service.BusDetailsService;

@WebServlet("/BusListServlet")
public class BusListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BusListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String agency = request.getParameter("agency");
			System.out.println(agency + agency.length());
			String busNo = request.getParameter("b_no");
			int busno = Integer.parseInt(busNo);
			String bustype = request.getParameter("bustype");
			String source = request.getParameter("source");
			String destination = request.getParameter("destination");
			String amt = request.getParameter("amount");
			double amount = Integer.parseInt(amt);
			BusDetails bus = new BusDetails(agency, busno, bustype, source, destination, amount);
			BusDetailsService busdetailsservice = new BusDetailsService();
			busdetailsservice.addBusDetails(bus);

			String message = "added";
			response.sendRedirect("BusList.jsp?infomessage=" + message);

		} catch (Exception e) {
			e.printStackTrace();
			String message = "unable to add";
			response.sendRedirect("addBusList.jsp" + message);
		}

	}
}
