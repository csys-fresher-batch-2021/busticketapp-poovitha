<%@page import="in.poovi.model.service.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

<h2>LOGIN</h2>
	<jsp:include page="register_action.jsp"></jsp:include>

<form action="LoginServlet">

        <br>
        <br>
        <label for="username">USERNAME</label>
        <input type="text" name="username" id="username" placeHolder="enter username" required autofocus>
        <br>
        <br>
        <label for="password">PASSWORD</label>
        <input type="text" name="password" id="password" placeHolder="enter password" required autofocus>
        <br>
        <br>
        <button type="submit">SUBMIT</button>
        <br>
        <br>
        <button type="reset">RESET</button>
        <br>
        
</form>
</main>        
</body>
</html>