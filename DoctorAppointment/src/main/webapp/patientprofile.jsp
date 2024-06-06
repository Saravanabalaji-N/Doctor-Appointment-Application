<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="patientprofile.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

</head>
<body>
    <div class="navbar">
        <h2>PATIENT PROFILE</h2>
        <ol>
            <li><a href="homepage.jsp"><i class="fa-solid fa-house"></i><span>Home</span></a></li>
           <li><i class="fa-solid fa-right-to-bracket"></i>Logout</li>
          
        </ol>
    </div>
    <div class="sidebar">
      <ol>
        <li><i class="fa-regular fa-clipboard"></i><span onclick="openLoginPopup()">Book Appointment</span></li>
        <li><i class="fa-solid fa-calendar-days"></i><span>Available Appointment</span></li>
        <li><i class="fa-solid fa-bars-staggered"></i><span>Account</span></li>
      </ol>
    </div>
    <div class="bookappointment" id="book">
    <div class="back">
        <button onclick="closeLoginPopup()">Back</button>
    </div>
      <form action="AppointmentBooking" method="post" >
        <h2>Book Appointment</h2>
        <label for="">Doctors</label>
        <select name="disease" id="care-type" name="disease">
          <option value="NormalCheckup">Normal Checkup</option>
          <option value="Fever">Fever</option>
          <option value="Diabetes">Diabetes</option>
          <option value="BloodPressure">Blood Pressure</option>
        </select>
        <label for="">date</label>
        <input type="date" name="date">
        <label for="">slot book</label>
        <select name="slot" id="slot">
          <option value="10-12 ">10-12 AM</option>
          <option value="1-3">1-3 PM</option>
          <option value="4-6 ">4-6 PM</option>
          <option value="8-9">8-9 PM</option>
        </select>
        <button type="submit" name="submit" value="submit">Book Slot</button>
    </form>
    </div>
    
        <script>
        function openLoginPopup() {
            document.getElementById('book').style.display = 'block';

        }

        function closeLoginPopup() {
            document.getElementById('book').style.display = 'none';
           
        }
    </script>
</body>
</html>