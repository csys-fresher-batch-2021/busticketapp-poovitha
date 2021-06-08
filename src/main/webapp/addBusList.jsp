<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>add bus</h1>
	<form action="BusListServlet" method="get">
		<table>
			<tr>
				<th scope="col">agency</th>
				<td><input type="text" name="agency" placeholder="Enter agency"
					id="agencyId" required autofocus></td>
			</tr>

			<tr>
				<th scope="col">busnumber</th>
				<td><input type="number" name="b_no" placeholder="Enter no"
					id="busnumberId" min=100 required></td>

			</tr>
			<tr>
				<th scope="col">bustype</th>
				<td><select name="bustype" required>
						<option value="NON AC SLEEPER">NON AC SLEEPER</option>
						<option value="AC SLEEPER">AC SLEEPER</option>
						<option value="NON AC SEATER">NON AC SEATER</option>
						<option value="AC SEATER">AC SEATER</option>

				</select></td>

			</tr>

			<tr>
				<th scope="col">amount</th>
				<td><input type="number" name="amount"
					placeholder="Enter amount" id="amountId" min=300 required></td>

			</tr>
		</table>
		<button type="submit">SUBMIT</button>
	</form>
</body>
</html>