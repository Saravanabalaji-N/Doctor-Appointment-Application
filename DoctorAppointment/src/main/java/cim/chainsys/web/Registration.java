package cim.chainsys.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.AppointBooking;
import com.chainsys.dao.LoginPage;
import com.chainsys.dao.User;
import com.chainsys.model.Admin;
import com.chainsys.util.DatabaseConnection;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	User user=new User();
//	LoginPage login = new LoginPage();
	AppointBooking booking= new AppointBooking();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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

		User user=new User();
		
		String name=request.getParameter("username");
		String mail=request.getParameter("mail");
		String password1=request.getParameter("pass1");
		String password2=request.getParameter("pass2");

		
		user.setUsername(name);
		user.setMailid(mail);
		user.setPassword(password1);
		user.setRepassword(password2);
		
		try {
			Admin.register(user);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	

}
