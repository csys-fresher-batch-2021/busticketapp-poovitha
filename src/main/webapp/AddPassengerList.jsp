<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.poovi.model.PassengerModel"%>
<%@page import="in.poovi.model.service.PassengerService"%>
<%@page import=" java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>ADD PassengerList</h1>
	<form action="PassengerListServlet" method="get">
		<table>

			<tr>
				<th scope="col">p_id :</th>
				<td><input type="number" name="pid" placeholder="Enter id"
					id="passengerId" min=100 required autofocus></td>
			</tr>
			<tr>
				<th scope="col">name :</th>
				<td><input type="text" name="pname" placeholder="Enter name"
					id="nameId" required autofocus></td>
			</tr>
			<tr>
				<th scope="col">age :</th>
				<td><input type="number" name="page" placeholder="Enter age"
					id="ageId" min=1 required autofocus></td>
			</tr>

			<tr>
				<th scope="col">gender :</th>
				<td><input type="text" name="pgender"
					placeholder="Enter gender" id="genderId" required></td>
			</tr>
			<tr>
				<th scope="col">mobile number:</th>
				<td><input type="text" name="pmobileno"
					placeholder="Enter mobileno" id="mobileId" required autofocus></td>
			</tr>

		</table>
		<button type="submit">SUBMIT</button>
	</form>




</body>
</html>