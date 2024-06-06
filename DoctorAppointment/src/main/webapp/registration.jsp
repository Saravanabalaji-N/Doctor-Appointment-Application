<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="registration.css">
</head>
<body>
   <div class="container">
    <div class="navbar">
        <h2>HOSPITAL</h2>
        <ol>
            <a href=""></a>
            <li><i class="fa-solid fa-house"></i><span>Home</span></li>
            <li><i class="fa-solid fa-chart-pie"></i></i><span>Admin</span></li>
           <li><i class="fa-solid fa-right-to-bracket"></i>Login</li>
           <li><i class="fa-solid fa-user"></i>Signup</li>
        </ol>
    </div>
    <div class="sidebar">
      <ol>
        <li>Book Appointment</li>
        <li>Available Appointment</li>
        <li>Account</li>
      </ol>
    </div>
   </div>
   <div class="signup">
    <div class="back">
       <a href="homepage.jsp"><button>Back</button></a>
    </div>
    <form action="Registration" method="post">
        <h2>Registration Page</h2>
        <label id="lable" for="">Username</label>
        <input type="text" placeholder="enter your username" name="username" required>
        <label id="lable" for="">E-mail</label>
        <input type="email" placeholder="enter your mail-id" name="mail" required>
        <label id="lable" for="">Password</label>
        <input type="password" placeholder="enter your password" name="pass1" required>
        <label id="lable" for="">Re-enter Password</label>
        <input type="password" placeholder="re-enter your password" name="pass2" required>
        <button type="submit" name="submit" value="submit">Login</button>
    </form>
   </div>
</body>
</html>