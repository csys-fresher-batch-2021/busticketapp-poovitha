<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="in.poovi.model.BusRoute" %>   
<%@page import="in.poovi.model.service.BusRouteService" %> 
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
	<form >
		<h3> DISPLAY ROUTES</h3>
		<table class="table table-bordered">
			<caption>Display <br>Bus Routes<br> along with <br>Bus Number</caption>
			<thead>
				<tr>
					<th scope="col">S.NO</th>
					<th scope="col">ROUTE NO</th>
					<th scope="col">SOURCE</th>
					<th scope="col">DESTINATION</th>
					<%
					List<BusRoute> busroute = BusRouteService.getBusRoute();
					int i = 0;
					for (BusRoute listRoute : busroute) {
						i++;
					%>
				</tr>
				<tr>
					<td><%=i%></td>
					<td><%=listRoute.getRouteNo()%></td>
					<td><%=listRoute.getSource()%></td>
					<td><%=listRoute.getDestination()%></td>
					<td><a href="BusList.jsp?" class="btn-btn-primary">clickhere</a></td>
					
				</tr>
				<%
				}
				%>
				
			</thead>
		</table>
					<a href="addBusRoute.jsp">Add Routes</a>
		


</form>
</main>


</body>
</html>