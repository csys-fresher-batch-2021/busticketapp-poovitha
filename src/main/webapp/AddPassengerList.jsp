<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="in.poovi.model.PassengerModel" %>
<%@page import="in.poovi.model.service.PassengerService" %> 
<%@page import=" java.util.List" %>
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
				<th scope="col">name :</th>
				<td><input type="text" name="passengername"
					placeholder="Enter name" id="nameId" required autofocus></td>
			</tr>
		
			<tr>
				<th scope="col">gender :</th>
				<td><input type="text" name="passengergender"
					placeholder="Enter gender" id="genderId" required></td>
					</tr>
						<tr>
				<th scope="col">age :</th>
				<td><input type="number" name="passengerage"
					placeholder="Enter age" id="ageId" required autofocus></td>
			</tr>
						<tr>
				<th scope="col">mobile number:</th>
				<td><input type="text" name="mobileno"
					placeholder="Enter mobileno" id="mobileId" required autofocus></td>
			</tr>
			
<%
List<PassengerModel> passengers=PassengerService.getAllPassengerListDB();
int  i=0;
for(PassengerModel passenger:passengers)
	i++;

%>
		</table>
		<button type="submit">SUBMIT</button>
	</form>




</body>
</html>