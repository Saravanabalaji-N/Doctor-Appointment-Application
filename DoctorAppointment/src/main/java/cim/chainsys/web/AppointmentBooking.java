package cim.chainsys.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.AppointBooking;
import com.chainsys.dao.User;
import com.chainsys.model.Admin;

/**
 * Servlet implementation class AppointmentBooking
 */
@WebServlet("/AppointmentBooking")
public class AppointmentBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user = new User();
	AppointBooking booking=new AppointBooking();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentBooking() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession getMail = request.getSession();
		String mail = (String) getMail.getAttribute("mail");
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
		
		try {
			Admin.doctorview(booking, user);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			request.setAttribute("view", Admin.doctorview(booking, user));
			request.getRequestDispatcher("view.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 PrintWriter out = response.getWriter();
		response.sendRedirect("view.jsp");

}
}
