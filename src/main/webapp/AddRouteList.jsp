<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">

		<h3>Add Route</h3>
		<jsp:include page="message.jsp"></jsp:include>
		<form onSubmit="addRoute()">
			<p id="message"></p>
			<br> <label for="name">From :</label> <input type="text"
				name="from" id="from" autocomplete="off" required
				placeholder="Enter from" autofocus><br /> <br> <label
				for="name">To :</label> <input type="text" name="to" id="to"
				autocomplete="off" required placeholder="Enter to"><br />
			<br>
			<button class="btn btn-secondary" type="submit">Add Route</button>
			<button class="btn btn-danger" type="reset">Reset</button>
			<br />
		</form>

		<script>
			
		function addRoute() {
			
				event.preventDefault();
				let from = document.querySelector("#from").value;
				let to = document.querySelector("#to").value;
				//let rating = document.querySelector("#rating").value;
				const queryParams = "?from=" + from + "&to=" + to ;
				let url = "AddServletJson" + queryParams ;				
				fetch(url).then(res=> res.json()).then(res=>{
				console.log(res);				
				let result=res;								
				console.log(result);				
				if(result.infoMessage != null){
					message=result.infoMessage;
				}
				else{
					message=result.errorMessage;
				}
				document.querySelector("#message").innerHTML=message;
				}
				);			
		}
		</script>

	</main>


</body>
</html>