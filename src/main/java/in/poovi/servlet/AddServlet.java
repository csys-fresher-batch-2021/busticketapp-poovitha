package in.poovi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.poovi.exception.ServiceException;
import in.poovi.service.Display;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			boolean isAdded = false;
			isAdded = Display.addList(from, to);
			if (isAdded) {
				String infomessage="sucessfully added";
				response.sendRedirect("listBusRoutes.jsp?infomessage=" +infomessage);
			} else {
				String errorMessage = "Unable to add Books ";
				response.sendRedirect("addList.jsp?errorMessage=" + errorMessage);
			}
		} catch (ServiceException e) {
			String errorMessage = "added";
			response.sendRedirect("addList.jsp?errorMessage=" + errorMessage);
		}

	}

}
