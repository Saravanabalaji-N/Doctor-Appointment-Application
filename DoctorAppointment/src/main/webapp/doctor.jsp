<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    	<%
			
			HttpSession Session = request.getSession();
			
			if(Session == null || Session.getAttribute("mail")==null){
				response.sendRedirect("adminlogin.jsp?event=Login");
				return;
			}
			%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
     <link rel="stylesheet" href="doctor.css">
 
 	<style type="text/css">
 	* {
    margin: 0;
    padding: 0;
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

.navbar ol{
    display: flex;
    align-items: center;
}

.navbar ol li{
	display:inline-block;
    padding-right: 30px;
    font-size: large;
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

.sidebar{
    height: 90vh;
    width: 20%;
    background-color: gray;
    float: left;
    }

.sidebar ol {
    width: 100%;
    height: 300px;
}

.sidebar ol li button{
	background-color: transparent;
	font-size:large;
	outline: 0;
	border: 0;
}

.sidebar ol li i{
	font-size:x-large;
	margin-right: 10px;
	color: blue;
}

.sidebar ol li{
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    text-decoration: none;
    text-align: left;
     margin-top: 50px;
    padding: 10px  10px 10px 20px; 
    font-size: large;
}

.sidebar ol li:hover{
    background-color: red;
}

.container {
    height: 80vh;
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 20px;
}

.container div {
    height: 200px;
    width: 200px;
    border-radius: 10px;
}

.container .box{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
}

.container .box i{
    font-size: 70px;
}
 	</style>
 
</head>
<body>
 <div class="navbar">
        <h2>DASHBOARD</h2>
        <ol>
            <li><i class="fa-solid fa-bell"></i></li>
            <li>Doctor Profile</li>
            
			
			<li><%=Session.getAttribute("mail")%></li>
		
			
		<form action="Logout" method="post">
		<input type="hidden" name="action" value="doctorlogout">
		<input type="submit" name="action" value="Logout">
		</form>
        </ol>
    </div>
    
    <div class="sidebar">
      <ol>
        <li>
        <form action="AppointmentBooking" >
        <i class="fa-regular fa-clipboard"></i>
        <button type="submit" id="view">View Appointment</button>
        </form></li>
        <li><i class="fa-solid fa-calendar-days"></i><span>Show Appointment</span></li>
        <li><i class="fa-solid fa-bars-staggered"></i><span>Account</span></li>
      </ol>
    </div>
   
    <div class="container">
        <div class="box">
            <p>appointment</p>
            <i class="fa-solid fa-briefcase"></i>
        </div>
        <div class="box">

        </div>
        <div class="box">

        </div>
    </div>
</body>
</html>