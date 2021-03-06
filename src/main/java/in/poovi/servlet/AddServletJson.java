package in.poovi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import in.poovi.exception.ServiceException;
import in.poovi.service.Display;

@WebServlet("/AddServletJson")
public class AddServletJson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddServletJson() {
		super();
	}
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		try {
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			Display.addList(from, to);
			JsonObject object = new JsonObject();
			object.addProperty("infoMessage", "Successfully Added");
			out.println(object);
		} catch (ServiceException e) {
			e.printStackTrace();
			JsonObject object = new JsonObject();
			object.addProperty("errorMessage", e.getMessage());
			out.println(object);
		}
		out.flush();

	}

}
