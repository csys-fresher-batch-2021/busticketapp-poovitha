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

>>>>>>> b846ff54936bcc13e4ca8d1beb959fd6c1cfe14a

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
=======
    public AddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
>>>>>>> b846ff54936bcc13e4ca8d1beb959fd6c1cfe14a
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
			
>>>>>>> b846ff54936bcc13e4ca8d1beb959fd6c1cfe14a

		} catch (Exception e) {
			String errorMessage = "add";
			response.sendRedirect("addList.jsp?errorMessage=" + errorMessage);
		}

	}

}
