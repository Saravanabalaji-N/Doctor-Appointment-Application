<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.chainsys.dao.AppointBooking" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <table border="1">
        <thead>
            <tr>
                <th>Appointment Id</th>
                <th>User Name</th>
                <th>Disease Type</th>
                <th>Appointment Day </th>
                <th>Appointment Date </th>
            </tr>
        </thead>
        <tbody>
          <% ArrayList<AppointBooking> list= (ArrayList<AppointBooking>)request.getAttribute("view");
              for(AppointBooking list1: list){
          %>
                <tr>
                    <td><%=list1.getId() %></td>
                    <td><%= list1.getUsername()%></td>
                    <td><%=list1.getDisease() %></td>
                    <td><%=list1.getDate() %></td>
                    <td><%=list1.getSlottime() %></td>
                </tr>
          <%} %>
        </tbody>
    </table>


</body>
</html>