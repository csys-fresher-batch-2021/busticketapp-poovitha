<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTER</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

<form>
        <h2>REGISTRATION</h2>
        <br>
        <label for="username">USERNAME</label>
        <input type="text" name="username" id="username" placeHolder="enter username" required autofocus>
        <br>
        <label for="mobilenumber">MOBILENUMBER</label>
        <input type="text" name="mobilenumber" id="mobilenumber" placeHolder="enter mobilenumber" required autofocus>
        <br>
        <label for="password">PASSWORD</label>
        <input type="text" name="password" id="password" placeHolder="enter password" required autofocus>
        <br>
        <label for="email">EMAIL</label>
        <input type="email" name="email" id="email" placeHolder="enter email" required autofocus>
        <br>
        <button type="submit">SUBMIT</button>
        <br>
        <button type="reset">RESET</button>
        <br>

</form>
</main>
</body>

</html>