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
import com.chainsys.model.DetailsOfDoctor;
import com.chainsys.model.LoginPage;
import com.chainsys.model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user =new User();
	LoginPage login=new LoginPage();
	 static DetailsOfDoctor details=new DetailsOfDoctor();
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session =request.getSession();
		
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		String profile=request.getParameter("profile");

		user.setMailid(mail);
		user.setPassword(pass);
		user.setProfile(profile);
//		System.out.println("000000000"+profile);
		
		try {
			Admin.usercheck(user);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
//		System.out.println("3333333333"+user.getProfile());
		
		String profession=user.getProfile();

		
		if (profession.equals("Patient")) {
			session.setAttribute("mail", mail);
			response.sendRedirect("patient.jsp");
			
		}
		else if(profession.equals("Doctor")) {
			session.setAttribute("mail", mail);
			response.sendRedirect("doctor.jsp");
		
		}
		else {
			response.sendRedirect("home.jsp");
			
	}
		
		
	}
}