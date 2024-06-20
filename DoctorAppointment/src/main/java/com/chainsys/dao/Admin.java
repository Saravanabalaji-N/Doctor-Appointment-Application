package com.chainsys.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import com.chainsys.model.Adminlogin;
import com.chainsys.model.AppointBooking;
import com.chainsys.model.DetailsOfDoctor;
import com.chainsys.model.LoginPage;
import com.chainsys.model.User;
import com.chainsys.util.DatabaseConnection;


public class Admin {

	public static void register(User user) throws SQLException, ClassNotFoundException {

		String query = "insert into user_login(user_id,user_profile,user_name,user_mailId,user_password) values(?,?,?,?,?)";
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, null);
		ps.setString(2, user.getProfile());
		ps.setString(3, user.getUsername());
		ps.setString(4, user.getMailid());
		ps.setString(5, user.getPassword());
		ps.executeUpdate();	
			}
	
	public static void adminregister(Adminlogin admin) throws SQLException, ClassNotFoundException {

		String query = "insert into doctor_details(doctor_id,doctor_name,doctor_specialization,doctor_mailId,doctor_password) values(?,?,?,?,?)";
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, null);
		ps.setString(2, admin.getAdminName());
		ps.setString(3, admin.getAdminSpec());
		ps.setString(4, admin.getAdminMail());
		ps.setString(5, admin.getAdminpass());
		ps.executeUpdate();
	}

	public static void appointmentbook(AppointBooking booking, User user) throws SQLException, ClassNotFoundException {
		String query = "insert into appointment_details(id,appointment_id,user_name,user_mailid,doctor_specialization,appointment_date,appointment_time) values(?,?,?,?,?,?,?)";
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, user.getId());
		ps.setString(2, null);
		ps.setString(3, user.getUsername());
		ps.setString(4, user.getMailid());
		ps.setString(5, booking.getDisease());
		ps.setString(6, booking.getDate());
		ps.setString(7, booking.getSlottime());
		ps.executeUpdate();

	}
	
	public static void doctordetails(DetailsOfDoctor details,User user) throws SQLException, ClassNotFoundException {
		String query = "insert into doctor_details(doctor_id,doctor_mailId,doctor_name,doctor_date,doctor_specialization,doctor_image) values(?,?,?,?,?,?)";
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, null);
		ps.setString(2, user.getUsername());
		System.out.println("11111111111"+user.getUsername());
		ps.setString(3, user.getMailid());
		ps.setString(4, details.getDoctorDob());
		ps.setString(5, details.getDoctorSpecs());
		ps.setString(6, details.getDoctorImage());
		ps.executeUpdate();
	}
	
	public static void usercheck(User user) throws ClassNotFoundException, SQLException {
		System.out.println("im here..........");
		String query = "select * from user_login where user_mailId=? and user_password=? and user_profile=?";
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, user.getMailid());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getProfile());
//		System.out.println("222222222"+user.getMailid());
//		System.out.println("222222222"+user.getPassword());
//		System.out.println("222222222"+user.getProfile());

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
		user.setUsername(rs.getString("user_name"));
		user.setMailid(rs.getString("user_mailId"));
		user.setProfile(rs.getString("user_profile"));
		}
		else {
		}
			}

	
	public static boolean admincheck(Adminlogin adminlogin) throws ClassNotFoundException, SQLException {

		String query = "select doctor_mailId,doctor_password from doctor_details where doctor_mailId=? and doctor_password=?";
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, adminlogin.getAdminMail());
		ps.setString(2, adminlogin.getAdminpass());
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return true;
		} else {
			
			return false;
		}
	}

	public static void registerview(User user) throws ClassNotFoundException, SQLException {
		String query = "select * from user_login where user_mailId=?";
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, user.getMailid());

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			user.setId(rs.getString("user_id"));
			user.setUsername(rs.getString("user_name"));
			user.setProfile(rs.getString("user_profile"));
		}
	}
	
	
	
	public static void adminview(Adminlogin adminlogin) throws ClassNotFoundException, SQLException {
		String query = "select * from doctor_details where doctor_mailId=?";
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, adminlogin.getAdminMail());

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			adminlogin.setAdminSpec((rs.getString("doctor_specialization")));

		}
	}

	public static ArrayList<AppointBooking> doctorview(Adminlogin adminlogin,String spec) throws ClassNotFoundException, SQLException {

		ArrayList<AppointBooking> list = new ArrayList<>();

		String query = "select * from appointment_details where doctor_specialization=? ";
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1,spec);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			AppointBooking booking=new AppointBooking();
			booking.setId(rs.getString("id"));
			booking.setId1(rs.getString("appointment_id"));
			booking.setUsername(rs.getString("user_name"));
			booking.setMailid(rs.getString("user_mailid"));
			booking.setDate(rs.getString("appointment_date"));
			booking.setSlottime(rs.getString("appointment_time"));

			list.add(booking);

		}
		return list;
	}

}
