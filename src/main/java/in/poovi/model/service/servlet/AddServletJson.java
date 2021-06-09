package in.poovi.model.service.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import in.poovi.model.service.BusRouteService;

@WebServlet("/AddServletJson")
public class AddServletJson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddServletJson() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		try {

<<<<<<< HEAD
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			Display.addList(from, to);
=======
        String from=request.getParameter("from");
		String to=request.getParameter("to");
			BusRouteService.addList(from,to);
>>>>>>> b846ff54936bcc13e4ca8d1beb959fd6c1cfe14a
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
