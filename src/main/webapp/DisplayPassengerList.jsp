<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>

<body>
	<h3>passenger list</h3>
	<table class="table	table-bordered">
		<caption>passenger details</caption>
		<thead>
			<tr>
			    <th scope="col">p_id</th>
				<th scope="col">p_name</th>
				<th scope="col">p_gender</th>
				<th scope="col">p_age</th>
				<th scope="col">p_mobileNumber</th>
				
			</tr>
		</thead>
		<tbody id="passengerlist">
		</tbody>


</table>
<script>
	function getAllDetails(){
	
	let url ="PassengerListServlet";
	fetch(url).then(res=>res.json()).then(res=>{
		
		let passengers = res;		
		let passengerDetails = "    ";
		let i=0;
		for(let passenger of passengers){
			    
			passengersdetails += "<tr><td>" +(++i)+ "</td><td>" + passenger.p_name + "</td><td>" +passenger.p_gender +"</td><td>"+passenger.p_age+"</td><td>"+passenger.p_mobileno+"</td></tr>";
		}
		
		document.querySelector("#passengerlist").innerHTML =passengerDetails ;
	})
	
	}
getAllDetails();

</script>
</body>
</html>