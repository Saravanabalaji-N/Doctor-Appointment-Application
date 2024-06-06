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
	
		String query="insert into user_login(user_id,user_name,user_mailId,user_password,user_re_password) values(?,?,?,?,?)";
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, null);
		ps.setString(2,user.getUsername() );
		ps.setString(3,user.getMailid() );
		ps.setString(4,user.getPassword() );
		ps.setString(5, user.getRepassword());	
		ps.executeUpdate();
		}	
	
	public static void Appointmentbook(AppointBooking booking,User user) throws SQLException, ClassNotFoundException {
		String query="insert into appointment_details(appointment_id,user_name,disease_type,appointment_date,appointment_time) values(?,?,?,?,?)";
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1,user.getId() );
		ps.setString(2,user.getUsername() );
		ps.setString(3,booking.getDisease() );
		ps.setString(4,booking.getDate() );
		ps.setString(5,booking.getSlottime());
		ps.executeUpdate();
	}
	
	public static boolean usercheck(LoginPage login) throws ClassNotFoundException, SQLException {
		
		String query="select user_mailId,user_password from user_login where user_mailId=? and user_password=?";
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1,login.getMail() );
		ps.setString(2,login.getPassword());
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()) {
			System.out.println("LOGIN SUCCESS");
			return true;
		}
		else {
		return false;
		}
	}
	
	public static void registerview(User user) throws ClassNotFoundException, SQLException {
		String query="select * from user_login where user_mailId=?";
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1,user.getMailid() );

		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			
			user.setId(rs.getString("user_id"));
			user.setUsername(rs.getString("user_name"));
			
		}	
	}
	
	public static ArrayList<AppointBooking> doctorview(AppointBooking booking,User user) throws ClassNotFoundException, SQLException {
		
		ArrayList<AppointBooking> list= new ArrayList<>();
		
		String query="select * from appointment_details where appointment_id=?";
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1,user.getId() );
		System.out.println(user.getId());
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			
			booking.setId(rs.getString("appointment_id"));
			booking.setUsername(rs.getString("user_name"));
			booking.setDisease(rs.getString("disease_type"));
			booking.setDate(rs.getString("appointment_date"));
			booking.setSlottime(rs.getString("appointment_time"));
			
			System.out.println(booking.getUsername());
			
			list.add(booking);
			
		}
		return list;
		}	
	
}

