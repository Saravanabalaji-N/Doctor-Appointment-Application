<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
@import
	url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}

body {
	min-height: 100vh;
	width: 100%;
}

.container {
	height: 80vh;
	display: flex;
}

.container img {
	width: 100%;
	opacity: 40%;
}

.container h2 {
	position: absolute;
	top: 20%;
	left: 50%;
	transform: translate(-50%, -50%);
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
	color: red;
	font-family: fantasy;
	font-weight: 100;
}

.navbar ol {
	display: flex;
	align-items: center;
}

.navbar ol li {
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	display: inline-block;
	padding-right: 30px;
	font-size: large;
	color: black;
	cursor: pointer;
}

.navbar ol li a{
	text-decoration: none;
	color:black
}


.navbar ol li i {
	font-size: x-large;
	margin-right: 10px;
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

.sidebar ol li {
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	text-decoration: none;
	text-align: left;
	margin-top: 50px;
	padding: 10px 10px 10px 20px;
	font-size: x-large;
}

.sidebar ol li:hover {
	background-color: white;
}

.footer{
height: 10vh;
background-color: gray;
}
</style>
</head>
<body>

	<div class="navbar">
		<h2>
			Book<span> My</span>Appointment
		</h2>

		<ol>
			<li><i class="fa-solid fa-house"></i><span>Home</span></li>
			<li><i class="fa-solid fa-chart-pie"></i><span><a
					href="loginsignup.jsp?event=Admin Login">Admin</a></span></li>
			<li><i class="fa-solid fa-user"></i><a href="loginsignup.jsp?event=Login" class="link"><span>Login/Signup</span></a></li>
		</ol>
	</div>

	<div class="container">
		<img alt=""
			src="img/creative-collage-telehealth-consultation_23-2149488756.jpg">
		<h2>Doctor Appointment Booking App For Patients</h2>
	</div>
	<div class="footer">
	<h4>Contact us : +91 9876567890</h4>
	</div>

</body>
</html>