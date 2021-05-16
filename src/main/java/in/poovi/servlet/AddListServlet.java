package in.poovi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.poovi.model.service.DisplayList;

/**
 * Servlet implementation class AddListServlet
 */
@WebServlet("/AddListServlet")
public class AddListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		String from=request.getParameter("from");
		String to=request.getParameter("to");

		
			HashMap<String,String> hashMap=new HashMap<>();
			out.println("Successfully Added");
            if(from==null && to==null) {
			    hashMap.put(from, to);
                for(String from1:hashMap.keySet()) {
				String to1=hashMap.get(from);
				System.out.println("FROM : " + from1 + " TO : " + to1);
                
            boolean isAdded=DisplayList.addList(from1, to1);
			if(isAdded) {
				response.sendRedirect("listBusRoutes.jsp");
			}else {
				String message="unable to added from the list";
				response.sendRedirect("addBusRoutes.jsp?errormessage"+message);
			}
                }
            }
		
	}
}

