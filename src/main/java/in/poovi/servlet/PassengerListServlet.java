package in.poovi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.poovi.exception.DBException;
import in.poovi.exception.ServiceException;
import in.poovi.service.PassengerService;

@WebServlet("/PassengerListServlet")
public class PassengerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PassengerListServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String pname = request.getParameter("pname");
			String pId = request.getParameter("pid");
			int pid = Integer.parseInt(pId);
			String pAge = request.getParameter("page");
			int page = Integer.parseInt(pAge);
			String pgender = request.getParameter("pgender");
			String pMobileno = request.getParameter("pmobileno");
			long pmobileno = Long.parseLong(pMobileno);
			boolean isadded = false;
			isadded = PassengerService.addpassenger(pname, pid, page, pgender, pmobileno);
			if (isadded) {
				String message = "added";
				response.sendRedirect("PassengerList.jsp?infomessage=" + message);
			}
		} catch (ServiceException | DBException e) {
			String message=e.getMessage();
			response.sendRedirect("AddPassengerList.jsp?errormessage=" +message);
		}
	}

}
