<%@ page import="in.poovi.model.service.DisplayList"%>
<%@page import="java.util.List"%>
<%@page import="in.poovi.model.DisplayBusRoutes"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BUS ROUTES</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<h2>List the Bus Routes</h2>
		<br>
		<form>
			<table class="table table-bordered">
				<caption>Bus route along with bus number</caption>

				<tbody>
				<thead>
					<tr>
						<th scope="col">ROUTE NO</th>
						<th scope="col">ROUTE FROM</th>
						<th scope="col">ROUTE TO</th>
						<%
						HashMap<String, String> hashMap = DisplayList.getList();
						int i = 0;
						for (String key : hashMap.keySet()) {
							String to = hashMap.get(key);
							i++;
						%>

					</tr>
				</thead>

				</tbody>
				<tr>
					<td><%=i%></td>
					<td><%=key%></td>
					<td><%=to%></td>
					<%
					}
					%>
				
			</table>
			<a href="addBusRoutes.jsp">Add Bus Routes</a>
            



		</form>
	</main>
</body>
</html>