package com.chainsys.dao;

public class User {

		String id;
		String username;
		String mailid;
		String password;
		String repassword;
		
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getMailid() {
			return mailid;
		}
		public void setMailid(String mailid) {
			this.mailid = mailid;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRepassword() {
			return repassword;
		}
		public void setRepassword(String repassword) {
			this.repassword = repassword;
		}
		
		
		public User(String username, String mailid, String password, String repassword) {
			super();
			this.username = username;
			this.mailid = mailid;
			this.password = password;
			this.repassword = repassword;
		}
		public User() {
			// TODO Auto-generated constructor stub
		}
		
	}

