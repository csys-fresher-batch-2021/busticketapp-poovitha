package in.poovi.model.service.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import in.poovi.model.service.Display;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String from = request.getParameter("from");
			String to= request.getParameter("to");
			//String noOfBook = request.getParameter("noOfBooks");
			//int noOfBooks = BookService.isParsable(noOfBook);
			//boolean validNoOfBooks = BookService.isValidNumber(noOfBooks);
			//String price = request.getParameter("cost");
			//int cost = BookService.isParsable(price);


			boolean isAdded = false;
		
				isAdded = Display.addList(from,to);
				if (isAdded) {
					response.sendRedirect("listBusRoutes.jsp");
				} else {
					String errorMessage = "Unable to add Books ";
					response.sendRedirect("addList.jsp?errorMessage=" + errorMessage);
				}
			

		} catch (Exception e) {
			String errorMessage = "add";
			response.sendRedirect("addList.jsp?errorMessage=" + errorMessage);
		}

		
	}


}
