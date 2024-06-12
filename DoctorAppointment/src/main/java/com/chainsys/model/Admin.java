package com.chainsys.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.dao.AppointBooking;
import com.chainsys.dao.LoginPage;
import com.chainsys.dao.User;
import com.chainsys.util.DatabaseConnection;

public class Admin {

	public static void register(User user) throws SQLException, ClassNotFoundException {

		String query = "insert into user_login(user_id,user_name,user_mailId,user_password) values(?,?,?,?)";
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, null);
		ps.setString(2, user.getUsername());
		ps.setString(3, user.getMailid());
		ps.setString(4, user.getPassword());
		ps.executeUpdate();
	}

	public static void Appointmentbook(AppointBooking booking, User user) throws SQLException, ClassNotFoundException {
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

	public static boolean usercheck(LoginPage login) throws ClassNotFoundException, SQLException {

		String query = "select user_mailId,user_password from user_login where user_mailId=? and user_password=?";
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, login.getMail());
		ps.setString(2, login.getPassword());
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			System.out.println("LOGIN SUCCESS");
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

		}
	}

	public static ArrayList<AppointBooking> doctorview(User user) throws ClassNotFoundException, SQLException {

		ArrayList<AppointBooking> list = new ArrayList<>();

		String query = "select * from appointment_details";
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			AppointBooking booking = new AppointBooking();
			booking.setId(rs.getString("id"));
			booking.setId1(rs.getString("appointment_id"));
			booking.setUsername(rs.getString("user_name"));
			booking.setMailid(rs.getString("user_mailid"));
			booking.setDisease(rs.getString("doctor_specialization"));
			booking.setDate(rs.getString("appointment_date"));
			booking.setSlottime(rs.getString("appointment_time"));

			list.add(booking);

		}
		return list;
	}

}
