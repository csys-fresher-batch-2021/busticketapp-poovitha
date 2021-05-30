<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import=" java.util.List"%>
<%@page import="in.poovi.dao.PassengerDAO"%>
<%@page import="in.poovi.model.PassengerModel"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form>
		<jsp:include page="header.jsp"></jsp:include>
		<main class="container-fluid">
			<h3>Passenger List</h3>

			<table class="table table-bordered">
				<caption>Passenger name along with details</caption>
				<thead>
					<tr>
						<th scope="col">sno</th>
						<th scope="col">p_id</th>
						<th scope="col">P_name</th>
						<th scope="col">P_age</th>
						<th scope="col">P_gender</th>
						<th scope="col">p_mobilenumber</th>
						<%
						List<PassengerModel> passengers = PassengerDAO.allpassengerList();
						int i = 0;
						for (PassengerModel passenger : passengers) {
							i++;
						%>
					
					<tr>
						<td><%=i%></td>
						<td><%=passenger.getPid()%>
						<td><%=passenger.getPname()%></td>
						<td><%=passenger.getPage()%></td>
						<td><%=passenger.getPgender()%></td>

						<td><%=passenger.getPmobileno()%></td>
					</tr>
					<%
					}
					%>
				</thead>
			</table>
			<a href="AddPassengerList.jsp">Add PassengerList</a>
		</main>
	</form>
</body>
</html>