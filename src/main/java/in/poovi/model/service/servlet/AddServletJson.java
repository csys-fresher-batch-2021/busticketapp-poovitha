package in.poovi.model.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import in.poovi.model.service.Display;

/**
 * Servlet implementation class AddServletJson
 */
@WebServlet("/AddServletJson")
public class AddServletJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServletJson() {
        super();
        // Default constructor
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		PrintWriter out = response.getWriter();
		try {
			Display.addList(from,to);
			JsonObject object = new JsonObject();
			object.addProperty("infoMessage", "Successfully Added");
			out.println(object); 	
		} catch (Exception e) {
			e.printStackTrace();
			JsonObject object = new JsonObject();
			object.addProperty("errorMessage", e.getMessage());
			out.println(object);
		}
		out.flush();

	
	}


}
