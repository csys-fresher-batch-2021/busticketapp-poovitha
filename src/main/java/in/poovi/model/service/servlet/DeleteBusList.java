package in.poovi.model.service.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.poovi.dao.BusDetailsDao;
//import in.poovi.model.BusDetails;
//import in.poovi.model.service.BusDetailsService;
import in.poovi.model.BusDetails;
import in.poovi.model.service.BusDetailsService;

/**
 * Servlet implementation class DeleteBusList
 */
@WebServlet("/DeleteBusList")
public class DeleteBusList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBusList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			//String agency = request.getParameter("agency");
			String agency = request.getParameter("agency");
			System.out.println("Agency=" + agency);
            BusDetailsService.deletebus(agency);
				response.sendRedirect("BusList.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("AddBusList.jsp?");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
