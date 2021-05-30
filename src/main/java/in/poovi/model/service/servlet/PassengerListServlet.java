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

import in.poovi.dao.PassengerDAO;
//import in.poovi.dao.PassengerDaoImpl;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         try {
        	 int pid=Integer.parseInt(request.getParameter("pid"));
        	 String pname=request.getParameter("pname");
        	 int page=Integer.parseInt(request.getParameter("page"));
        	 String pgender=request.getParameter("pgender");
        	 long pmobileno=Long.parseLong(request.getParameter("pmobileno"));
        	 boolean isadded=false;
        	 isadded= PassengerService.addpassenger(pid, pname, page, pgender, pmobileno);
        	 if(isadded) {
        		 String message="added";
        		 response.sendRedirect("PassengerList.jsp?infomessage="+message);
        	 }
        	 }
        	 catch(Exception e) {
        		 response.sendRedirect("AddPassengerList.jsp");
        	 }
         }
         
	}
