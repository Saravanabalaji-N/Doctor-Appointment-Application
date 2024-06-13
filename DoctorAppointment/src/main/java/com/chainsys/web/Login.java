package com.chainsys.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.ProcessBuilder.Redirect;
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
import com.chainsys.model.LoginPage;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AppointBooking booking = new AppointBooking();
	Adminlogin adminlogin = new Adminlogin();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mail = request.getParameter("adminmail");
		String password = request.getParameter("adminpass");
		adminlogin.setAdminMail(mail);
		adminlogin.setAdminpass(password);

		HttpSession session = request.getSession();
		HttpSession sess = request.getSession();
		try {
			if (Admin.admincheck(adminlogin) == true) {
				
				Admin.adminview(adminlogin);
				sess.setAttribute("spec", adminlogin.getAdminSpec());
				session.setAttribute("mail", mail);
				
				response.sendRedirect("doctor.jsp");
			} else {
				response.sendRedirect("adminlogin.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		LoginPage login = new LoginPage();

		String mail = request.getParameter("mail");
		String password = request.getParameter("pass");
		login.setMail(mail);
		login.setPassword(password);

		HttpSession session = request.getSession();

		try {
			if (Admin.usercheck(login) == true) {
				session.setAttribute("mail", mail);
				response.sendRedirect("patient.jsp");
			} else {

				response.sendRedirect("loginsignup.jsp=event?Login");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}