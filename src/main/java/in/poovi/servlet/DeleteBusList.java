package in.poovi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.poovi.service.BusDetailsService;

@WebServlet("/DeleteBusList")
public class DeleteBusList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteBusList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String busNumber = request.getParameter("busnumber");
			int busnumber=Integer.parseInt(busNumber);
			System.out.println("Agency=" + busnumber);
			BusDetailsService.deleteBus(busnumber);
			response.sendRedirect("BusList.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("AddBusList.jsp?");
		}

	}

}
