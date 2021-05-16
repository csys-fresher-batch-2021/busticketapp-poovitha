<%@ page import="in.poovi.model.service.DisplayList"%>
<%@page import="in.poovi.model.DisplayBusRoutes"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add bus routes</title>

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h2>ADD BUSROUTES</h2>
		<jsp:include page="register_action.jsp"></jsp:include>

		<form action="AddListServlet" method="get"></form>
		<table>
			<thead>
				<tr>
					<td>FROM :</td>
					<td><input type="text" name="FROM" placeholder="Enter from"
						id="fromId" required autofocus></td>

				</tr>
				<tr>
					<td>TO :</td>
					<td><input type="text" name="TO" placeholder="Enter to"
						id="toId" required autofocus></td>
	<!-- 
					<%
					HashMap<String, String> hashMap1 = DisplayList.getList();
					int j = 0;
					for (String key : hashMap1.keySet()) {
						String to = hashMap1.get(key);
						j++;
					%>

				</tr>
			</thead>


			<tr>
				<td><%=j%></td>
				<td><%=key%></td>
				<td><%=to%></td>
				<%
				}
				%>
			 -->
		</table>
		<button type="submit">SUBMIT</button>
        <a href="listBusRoutes.jsp"></a>


	</main>

</body>

</html>