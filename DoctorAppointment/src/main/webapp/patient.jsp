<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
HttpSession Session = request.getSession();

if (Session == null || Session.getAttribute("mail") == null) {
	response.sendRedirect("home.jsp");
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
	letter-spacing: 1px;
	font-family: cursive;
}

.navbar h2 span {
	color: #d62300;
	font-family: fantasy;
	font-weight: 100;
}

.navbar ol {
	display: flex;
	align-items: center;
}

.navbar ol li {
	display: inline-block;
	padding-right: 20px;
	cursor: pointer;
}

.navbar ol form {
	padding-right: 20px;
}

.navbar ol form input {
	border: none;
	background: transparent;
	font-size: large;
	cursor: pointer;
}

.sidebar {
	height: 10vh;
	width: 100%;
	background-color: #ddd8ce;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.sidebar button {
	padding: 16px 12px;
	font-size: 16px;
	background: transparent;
	outline: 0;
	border: 0;
}

.sidebar p {
	padding-left: 15px;
}

.sidebar ol {
	height: 100%;
	display: flex;
	justify-content: flex-end;
	align-items: center;
	padding-right: 30px;
	gap: 20px;
}

.sidebar ol li {
	display: inline-block;
}

.container {
	height: 15vh;
	width:100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

.container2 {
	display: flex;
	height:65vh;
	justify-content: center;
	align-items: center;
	gap:40px;
	position: relative;
}


.container2 div {
	height: 320px;
	width: 250px;
	border-radius: 10px;
}

.container2 .box {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
	border: 1px solid black;
}

.container2 h2 {
	font-size: 34px;
}

.container2 .box p {
	width: 100%;
	background: transparent;
	border: none;
	font-size: 16px;
	text-align: center;
	margin-bottom: 6px;
}

.container2 .box {
	text-align: center;
}

.container2 .box input {
	width: 100%;
	background: transparent;
	font-size: 16px;
	text-align: center;
	padding: 10px 20px;
	border: 0;
	border-radius: 10px;
	background-color: gray;
	transition: ease 0.1s;
}

.container2 .box input:hover {
	background-color: #d62300;;
	color: #fff;
}

.search-container{
width: 100%;
text-align: center;
}

.search-container input {
   width:40%;
	padding: 15px 20px;
	outline: 0;
	border: 0;
	font-size: 16px;
	border-radius: 10px 0px 0px 10px;
	background-color: #aaaaaa;
	opacity: 40%;
}

.search-container button {
	padding: 14px;
	outline: 0;
	border: 0;
	font-size: 17px;
	border-radius: 0px 10px 10px 0px;
	border: 1px solid #034694;
	background: #034694;
	color:#fff;
}

.search-container button i {
	color: #fff;
}

.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	cursor: pointer;
	font-size: 16px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.dropdown-content {
	display: none;
	position: absolute;
	right: 2%;
	background-color: #f9f9f9;
	min-width: 155px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
	border-radius: 0px 0px 10px 10px;
}

.dropdown-content a {
	background-color: #fff;
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.show {
	display: block;
}
</style>

</head>
<body>
	<div class="navbar">
		<img alt="" src="img/dpulselogo-300x106.png" height="100%">
		<ol>
			<li><i class="fa-solid fa-heart-pulse"></i></li>

			<li><div class="dropdown">
					<button class="dropbtn" onclick="myFunction()"
						style="color: black;">
						<i class="fa-solid fa-bars-staggered"></i>
					</button>
					<div class="dropdown-content" id="myDropdown">
						<a href=" ">Profile</a> <a href="">
							<form action="Logout" method="post">
								<input type="hidden" name="action" value="doctorlogout">
								<input type="submit" name="action" value="Logout">
							</form>
						</a>
					</div>
				</div></li>
		</ol>
	</div>

	<div class="sidebar">
		<p>
			Welcome,
			<%=Session.getAttribute("mail")%></p>
		<ol>
			<li>
				<form action="">
					<button type="submit" id="view">View Appointment</button>
					<i class="fa-regular fa-clipboard"></i>
				</form>
			</li>
			<li><form action="">
					<button type="submit" id="view">Edit Appointment</button>
					<i class="fa-solid fa-calendar-days"></i>
				</form></li>
		</ol>
	</div>

	<div class="container">
		<div class="search-container">

				<input type="text" placeholder="Search.." name="search">
				<button type="submit">
					SEARCH <i class="fa fa-search"></i>
				</button>
		</div>
	</div>
	
	<div class="container2">
			<div class="box">
				<img alt=""
					src="img/male-doctor-with-stethoscope-vector-icon-circle-white-background_418020-88.avif"
					height="220px" width="180px">
				<p>Cardiologist</p>
				<form action="AppointmentCheck" method="post">
					<input type="hidden" name="action" value="Cardiologist"> <input
						type="submit" value="book appointment">
				</form>
			</div>
			<div class="box">
				<img alt=""
					src="img/male-doctor-with-stethoscope-vector-icon-circle-white-background_418020-88.avif"
					height="220px" width="180px">
				<p>Dermatologists</p>
				<form action="AppointmentCheck" method="post">
					<input type="hidden" name="action" value="Dermatologists">
					<input type="submit" value="book appointment">
				</form>

			</div>
			<div class="box">
				<img alt=""
					src="img/male-doctor-with-stethoscope-vector-icon-circle-white-background_418020-88.avif"
					height="220px" width="180px">
				<p>Gastroenterologists</p>
				<form action="AppointmentCheck" method="post">
					<input type="hidden" name="action" value="Gastroenterologists">
					<input type="submit" value="book appointment">
				</form>
			</div>
			<div class="box">
				<img alt=""
					src="img/male-doctor-with-stethoscope-vector-icon-circle-white-background_418020-88.avif"
					height="220px" width="180px">
				<p>Neurologist</p>
				<form action="AppointmentCheck" method="post">
					<input type="hidden" name="action" value="Neurologist"> <input
						type="submit" value="book appointment">
				</form>
			</div>
		</div>
	<script>
		function myFunction() {
			document.getElementById("myDropdown").classList.toggle("show");
		}

		window.onclick = function(e) {
			if (!e.target.matches('.dropbtn')) {
				var myDropdown = document.getElementById("myDropdown");
				if (myDropdown.classList.contains('show')) {
					/*  myDropdown.classList.remove('show'); */
				}
			}
		}
	</script>
</body>
</html>