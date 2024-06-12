package cim.chainsys.web;

import java.io.IOException;
import java.io.Writer;
import java.lang.ProcessBuilder.Redirect;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.LoginPage;
import com.chainsys.model.Admin;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginPage login = new LoginPage();

		String mail = request.getParameter("mail");
		String password = request.getParameter("pass");
		login.setMail(mail);
		login.setPassword(password);

		HttpSession session = request.getSession();
		session.setAttribute("mail", mail);
		if (mail.equals("admin@gmail.com") && password.equals("admin")) {
			response.sendRedirect("doctor.jsp");
		} else {
			try {
				if (Admin.usercheck(login) == true) {
					response.sendRedirect("patient.jsp");
				} else {
					response.sendRedirect("homepage.jsp");
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
