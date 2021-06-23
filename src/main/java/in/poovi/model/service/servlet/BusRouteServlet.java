package in.poovi.model.service.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.poovi.model.BusRoute;
import in.poovi.service.BusRouteService;

@WebServlet("/BusRouteServlet")
public class BusRouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BusRouteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int routeno = Integer.parseInt(request.getParameter("routeno"));
		System.out.println(routeno);
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");

		try {
			BusRoute route = new BusRoute(routeno, source,destination);
			BusRouteService busrouteservice = new BusRouteService();
			busrouteservice.addRouteList(route);

			String message = "added";
			response.sendRedirect("BusRoute.jsp?infomessage=" + message);

		} catch (Exception e) {
			e.printStackTrace();
			String message = "unable to add";
			response.sendRedirect("addBusRoute.jsp" + message);
		}

	}

}
