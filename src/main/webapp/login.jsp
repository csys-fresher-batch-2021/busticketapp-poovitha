<%@page import="in.poovi.service.Login"%>
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
<form action=login_action.jsp>

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