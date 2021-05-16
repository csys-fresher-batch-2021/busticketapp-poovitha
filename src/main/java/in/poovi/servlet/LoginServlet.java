package in.poovi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.poovi.model.service.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    
            PrintWriter out=response.getWriter();
            out.println("success");
            String username=request.getParameter("username");
            String password=request.getParameter("password");		
            boolean isvalid=Login.login(username, password);
		   if (isvalid)
		     {
			        
			   String message="Successfully loggedin";
		        response.sendRedirect("register_action.jsp?infoMessage="+ message); //logged-in page      		
		     }
			        
		     else {
           String message="Invalid Login Credentials";
			response.sendRedirect("login.jsp?errorMessage=" + message);
		     }
		     
		}
}


