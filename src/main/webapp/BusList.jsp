<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="in.poovi.model.BusDetails"%>
<%@page import="java.util.List"%>
<%@page import="in.poovi.dao.BusDetailsDAO"%>
<%@page import="in.poovi.dao.impl.BusDetailsDAOImpl"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<form>
		<h3>DISPLAY BUSLIST</h3>
		<%
		String BusSource = request.getParameter("source");
		String BusDestination = request.getParameter("destination");
		BusDetailsDAO busdetailsdao = new BusDetailsDAOImpl();
		%>
		<table class="table table-bordered">
			<caption>Display Bus along with Bus Number</caption>
			<thead>
				<tr>
					<th scope="col">S.NO</th>
					<th scope="col">AGENCY</th>
					<th scope="col">BUSNUMBER</th>
					<th scope="col">BUSTYPE</th>
					<th scope="col">SOURCE</th>
					<th scope="col">DESTINATION</th>
					<th scope="col">AMOUNT</th>

					<%
					List<BusDetails> bus = busdetailsdao.findAll();
					int i = 0;
					for (BusDetails busdetails : bus) {
						i++;
					%>
				</tr>
				<tr>
					<td><%=i%></td>
					<td><%=busdetails.getAgency()%></td>
					<td><%=busdetails.getBusnumber()%></td>
					<td><%=busdetails.getBusType()%></td>
					<td><%=busdetails.getSource()%></td>
					<td><%=busdetails.getDestination()%></td>
					<td><%=busdetails.getAmount()%></td>
					<td><a href="Booking.jsp">book</a>
					<td><a
						href="DeleteBusList?busnumber=<%=busdetails.getBusnumber()%>"
						class="btn-btn-danger">Delete</a></td>

				</tr>
				<%
				}
				%>

			</thead>
		</table>
		<a href="addBusList.jsp">Add bus</a>



	</form>

</body>
</html>