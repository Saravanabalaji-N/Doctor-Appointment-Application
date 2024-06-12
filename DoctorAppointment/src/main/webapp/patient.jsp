<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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

.navbar ol li a {
	text-decoration: none;
	color: black;
	font-weight: 100;
	padding-left: 10px;
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
	align-items: center;
	box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
}

.container .box i {
	font-size: 70px;
}
</style>

</head>
<body>
	<div class="navbar">
		<h2>PATIENT PROFILE</h2>
		<ol>
			<%
			HttpSession getMail = request.getSession();
			%>
			<li><%=getMail.getAttribute("mail")%></li>
			<li><i class="fa-solid fa-right-to-bracket"><a
					href="home.jsp">Logout</a></i></li>

		</ol>
	</div>
	<div class="sidebar">
		<ol>
			<li><i class="fa-solid fa-calendar-days"></i><span>Available
					Appointment</span></li>
			<li><i class="fa-solid fa-bars-staggered"></i><span>Account</span></li>
		</ol>
	</div>
	<div class="container">
		<div class="box">

			<p>Cardiologist</p>
			<input type="hidden" name="doctors" value="Cardiologist"> <a
				href="bookappointment.jsp?event=Cardiologist">Book Appointment</a>

		</div>
		<div class="box">

			<p>Dermatologists</p>
			<input type="hidden" name="doctors" value="Dermatologists"> <a
				href="bookappointment.jsp?event=Dermatologists">Book Appointment</a>
		</div>
		<div class="box">

			<p>Gastroenterologists</p>
			<input type="hidden" name="doctors" value="Gastroenterologists">
			<a href="bookappointment.jsp?event=Gastroenterologists">Book
				Appointment</a>


		</div>
		<div class="box">

			<p>Neurologist</p>
			<input type="hidden" name="doctors" value="Neurologist"> <a
				href="bookappointment.jsp?event=Neurologist">Book Appointment</a>

		</div>
	</div>
</body>
</html>