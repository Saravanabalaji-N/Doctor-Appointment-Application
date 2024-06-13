package com.chainsys.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.Admin;
import com.chainsys.model.Adminlogin;
import com.chainsys.model.AppointBooking;
import com.chainsys.model.User;

/**
 * Servlet implementation class AppointmentBooking
 */
@WebServlet("/AppointmentBooking")
public class AppointmentBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user = new User();
	AppointBooking booking=new AppointBooking();
	Adminlogin adminlogin=new Adminlogin();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentBooking() {
        super();

    }

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession sess=request.getSession();
		String spec=(String) sess.getAttribute("spec");
	
		
		try {
			request.setAttribute("view", Admin.doctorview(adminlogin,spec));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("view.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
			HttpSession Session = request.getSession();
			String mail = (String) Session.getAttribute("mail");
			String disease=request.getParameter("disease");
			String date=request.getParameter("date");
			String slotbook=request.getParameter("slot");
			booking.setDisease(disease);
			booking.setDate(date);
			booking.setSlottime(slotbook);
			user.setMailid(mail);
			
	
			try {
				Admin.registerview(user);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			try {
				Admin.Appointmentbook(booking, user);
			
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
			PrintWriter out=response.getWriter();
			out.println("you are successfully booked the slot");
		}
	
}
