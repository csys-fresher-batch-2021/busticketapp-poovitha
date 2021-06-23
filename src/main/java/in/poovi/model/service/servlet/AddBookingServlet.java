package in.poovi.model.service.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.poovi.model.Booking;
import in.poovi.service.BookingService;

@WebServlet("/AddBookingServlet")
public class AddBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddBookingServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookingno = Integer.parseInt(request.getParameter("bookingno"));
		int pid = Integer.parseInt(request.getParameter("pid"));
        String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String agency = request.getParameter("agency");
		System.out.println(agency + agency.length());
		int busno = Integer.parseInt(request.getParameter("b_no"));
		String bustype = request.getParameter("bustype");
		double amount = Integer.parseInt(request.getParameter("amount"));
		int nooftickets = Integer.parseInt(request.getParameter("nooftickets"));
		double totalamount = Integer.parseInt(request.getParameter("totalamount"));
		String status = request.getParameter("status");
		try {
			Booking booking = new Booking(bookingno, pid, source, destination, agency, busno, bustype, amount,
					nooftickets, totalamount, status);
			BookingService bookingservice = new BookingService();
			bookingservice.addReservation(booking);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
