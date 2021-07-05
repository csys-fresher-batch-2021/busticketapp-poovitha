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
	<form action="BusRouteServlet" method="get">
		<figure>
			<figcaption>Add BusRoute</figcaption>

			<table class="add busroute">
				<tr>
						<th scope="col">routeno</th>
						<td><input type="number" name="routeno" placeholder="Enter no"
							id="routeId" min=1 required autofocus></td>
					</tr>
			
				<tr>
						<th scope="col">source</th>
						<td><input type="text" name="source" placeholder="Enter from"
							id="sourceId" required autofocus></td>
					</tr>

					<tr>
						<th scope="col">to</th>
						<td><input type="text" name="destination" placeholder="Enter to"
							id="destinationId" required></td>

					</tr>


				</table>
				<button type="submit">SUBMIT</button>
				</figure>
	</form>

</body>
</html>