package in.poovi.model.service.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import in.poovi.model.service.Display;
=======

import in.poovi.model.service.BusRouteService;
>>>>>>> 32a175a67f5e0b70b49862ddbcd4b038c7b31d7f

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddServlet() {
		super();
	}

<<<<<<< HEAD
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
=======

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
>>>>>>> 32a175a67f5e0b70b49862ddbcd4b038c7b31d7f
		try {
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			boolean isAdded = false;
<<<<<<< HEAD

			isAdded = Display.addList(from, to);
			if (isAdded) {
				response.sendRedirect("listBusRoutes.jsp");
			} else {
				String errorMessage = "Unable to add Books ";
				response.sendRedirect("addList.jsp?errorMessage=" + errorMessage);
			}
=======
		
				isAdded = BusRouteService.addList(from,to);
				if (isAdded) {
					response.sendRedirect("listBusRoutes.jsp");
				} else {
					String errorMessage = "Unable to add Books ";
					response.sendRedirect("addList.jsp?errorMessage=" + errorMessage);
				}
>>>>>>> 32a175a67f5e0b70b49862ddbcd4b038c7b31d7f

		} catch (Exception e) {
			String errorMessage = "add";
			response.sendRedirect("addList.jsp?errorMessage=" + errorMessage);
		}

	}

}
