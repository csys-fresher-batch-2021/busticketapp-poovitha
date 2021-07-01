package in.poovi.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

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
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
            String bookingNo = request.getParameter("bookingno");
			int bookingno = Integer.parseInt(bookingNo);
			String pId = request.getParameter("pid");
			int pid = Integer.parseInt(pId);
			String source = request.getParameter("source");
			String destination = request.getParameter("destination");
			String agency = request.getParameter("agency");
			String busNo = request.getParameter("b_no");
			int busno = Integer.parseInt(busNo);
			String bustype = request.getParameter("bustype");
			String amt = request.getParameter("amount");
			double amount = Integer.parseInt(amt);
			String noOfTickets = request.getParameter("nooftickets");
			int nooftickets = Integer.parseInt(noOfTickets);
			String totalAmount = request.getParameter("totalamount");
			double totalamount = Integer.parseInt(totalAmount);
			String journeyDate = request.getParameter("journeyDate");
			LocalDateTime journeydate = LocalDateTime.parse(journeyDate);
			String bookingDate = request.getParameter("bookingDate");
			LocalDateTime bookingdate = LocalDateTime.parse(bookingDate);
			String status = request.getParameter("status");
			Booking booking = new Booking(bookingno, pid, source, destination, agency, busno, bustype, amount,
					nooftickets, totalamount, bookingdate, journeydate, status);
			BookingService bookingservice = new BookingService();
			bookingservice.addReservation(booking);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
