<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="in.poovi.model.MyList" %>
<%@page import="java.util.List"%>
<%@page import="in.poovi.model.service.Display" %>    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>BUS ROUTES</title>
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
					<th scope="col">FROM</th>
					<th scope="col">TO</th>
					<%
					List<MyList> books = Display.getList();
					int i = 0;
					for (MyList listDetails : books) {
						i++;
					%>
				</tr>
				<tr>
					<td><%=i%></td>
					<td><%=listDetails.from()%></td>
					<td><%=listDetails.to()%></td>
					<td><a href="BusList.jsp?" class="btn-btn-primary">clickhere</a></td>
					
				</tr>
				<%
				}
				%>
				
			</thead>
		</table>
					<a href="addList.jsp">Add Routes</a>
		


</form>
</main>
</body>
</html>