<%@page import="in.poovi.service.Login"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
</head>
<body>
 <%
String username  = request.getParameter("username");
String password = request.getParameter("password");
boolean valid = Login.login(username, password);
if(valid){
	out.println("Successfully LoggedIn");
}
else
{
	String message="Invalid Login Credentials";
	response.sendRedirect("register_action.jsp?errorMessage=" + message);
}

%>



</body>
</html>