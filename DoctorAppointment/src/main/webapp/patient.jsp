<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%
			
			HttpSession Session = request.getSession();
			
			if(Session == null || Session.getAttribute("mail")==null){
				response.sendRedirect("loginsignup.jsp?event=Login");
				return;
			}
			%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}



.navbar {
	display: flex;
	justify-content: space-between;
	height: 10vh;
	width: 100%;
}

.navbar h2 {
	padding: 20px;
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	letter-spacing: 1px;
}

.navbar ol {
	display: flex;
	align-items: center;
}

.navbar ol li {
	display: inline-block;
	padding-right: 30px;
	cursor: pointer;
}

.navbar ol form {
padding-right: 20px;

}

.navbar ol form input{
	border:none;
	background: transparent;
	font-size: large;
	cursor: pointer;
}

.sidebar {
	height: 90vh;
	width: 20%;
	background-color: gray;
	float: left;
}

.sidebar ol {
	width: 100%;
	height: 300px;
}

.sidebar ol li button {
	background-color: transparent;
	font-size: large;
	outline: 0;
	border: 0;
}

.sidebar ol li i {
	font-size: x-large;
	margin-right: 10px;
	color: blue;
}

.sidebar ol li {
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	text-decoration: none;
	text-align: left;
	margin-top: 50px;
	padding: 10px 10px 10px 20px;
	font-size: large;
}

.sidebar ol li:hover {
	background-color: red;
}

.container {
	height: 90vh;
	display: flex;
	justify-content: center;
	align-items: center;
	gap: 20px;
}

.container div {
	height: 300px;
	width: 200px;
	border-radius: 10px;
}

.container .box {
	display: flex;
	flex-direction: column;
	justify-content: center;
	box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
}

.container .box p{
	width:100%;
	background: transparent;
	border: none;
	font-size: 16px;
	text-align: center;
	margin-bottom: 6px;
}

.container .box{
text-align: center;
}

.container .box input {
	width:80%;
	background: transparent;
	font-size: 16px;
	text-align: center;
	padding: 7px;
	border:0;
	border-radius: 10px;
	background-color: gray;
	transition:ease-in  0.5s;
}
.container .box input:hover{
background-color: #72A0C1;
color:#fff;
}

</style>

</head>
<body>
	<div class="navbar">
		<h2>PATIENT PROFILE</h2>
		<ol>
			<li><%=Session.getAttribute("mail")%></li>
			
		<form action="Logout" method="post">
		<input type="hidden" name="action" value="patientlogout">
		<input type="submit"  value="Logout">
		</form>
		</ol>
	</div>
	<div class="sidebar">
		<ol>
			<li><i class="fa-solid fa-calendar-days"></i><span>Available
					Appointment</span></li>
			<li><i class="fa-solid fa-bars-staggered"></i><span>Account</span></li>
		</ol>
	</div>
	<div>

	</div>
	<div class="container">
		<div class="box">
			<img alt="" src="img/male-doctor-with-stethoscope-vector-icon-circle-white-background_418020-88.avif" height="220px" width="200px">
			<p>Cardiologist</p>
			<form action="AppointmentCheck"  method="post">
			<input type="hidden" name="action" value="Cardiologist">
			<input type="submit" value="book appointment">
			</form>
		</div>
		<div class="box">
			<img alt="" src="img/male-doctor-with-stethoscope-vector-icon-circle-white-background_418020-88.avif" height="220px" width="200px">
			<p>Dermatologists</p> 
			<form action="AppointmentCheck"  method="post">
			<input type="hidden" name="action" value="Dermatologists">
			<input type="submit" value="book appointment">
			</form>
		
		</div>
		<div class="box">
			<img alt="" src="img/male-doctor-with-stethoscope-vector-icon-circle-white-background_418020-88.avif" height="220px" width="200px">
			<p>Gastroenterologists</p>
			<form action="AppointmentCheck"  method="post">
			<input type="hidden" name="action" value="Gastroenterologists">
			<input type="submit" value="book appointment">
			</form>


		</div>
		<div class="box">
			<img alt="" src="img/male-doctor-with-stethoscope-vector-icon-circle-white-background_418020-88.avif" height="220px" width="200px">
			<p>Neurologist</p>
			<form action="AppointmentCheck"  method="post">
			<input type="hidden" name="action" value="Neurologist">
			<input type="submit" value="book appointment">
			</form>

		</div>
	</div>
</body>
</html>