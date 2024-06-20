package com.chainsys.web;

import java.io.IOException;
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
import com.chainsys.model.DetailsOfDoctor;
import com.chainsys.model.User;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Adminlogin adminlogin = new Adminlogin();
	static User user = new User();
	static User user1 = new User();
	static AppointBooking booking = new AppointBooking();
	static DetailsOfDoctor details = new DetailsOfDoctor();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registration() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("username");
		String mail = request.getParameter("mail");
		String spec = request.getParameter("type");
		String password1 = request.getParameter("pass");
		String password2 = request.getParameter("re-pass");

		if (password1.equals(password2)) {
			adminlogin.setAdminName(name);
			adminlogin.setAdminMail(mail);
			adminlogin.setAdminpass(password2);
			adminlogin.setAdminSpec(spec);
		}

		try {
			Admin.adminregister(adminlogin);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		
		String profile = request.getParameter("profile");
		String name = request.getParameter("username");
		String mail = request.getParameter("mail");
		String password1 = request.getParameter("pass");
		String password2 = request.getParameter("re-pass");

		if (password1.equals(password2)) {
			user.setProfile(profile);
			user.setUsername(name);
			user.setMailid(mail);
			user.setPassword(password1);
			
			session.setAttribute("name", name);
			session.setAttribute("mail", mail);
		}

		try {
			Admin.register(user);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("home.jsp");

		try {
			Admin.doctordetails(details, user);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}