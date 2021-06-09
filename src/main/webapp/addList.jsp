<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>ADD ROUTE</h1>
	<form action="AddServlet" method="get">
		<figure>
			<figcaption>Add BusRoute</figcaption>

			<table class="add BusRoute">
				<tr>
						<th scope="col">from</th>
						<td><input type="text" name="fromlocation" placeholder="Enter from"
							id="fromId" required autofocus></td>
					</tr>

					<tr>
						<th scope="col">to</th>
						<td><input type="text" name="tolocation" placeholder="Enter to"
							id="toId" required></td>

					</tr>


				</table>
				<button type="submit">SUBMIT</button>
				</figure>
	</form>




</body>
</html>
