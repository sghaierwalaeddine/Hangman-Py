package models;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import dao.ConnexionBD;

public class User {	
	private String userId;
	private String fullName;
	private String email;
	private String password;
	private Byte[] img;

	public User(String userId,String fullName, String email, String password, Byte[] img) {
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.img = img;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Byte[] getImg() {
		return img;
	}

	public void setImg(Byte[] img) {
		this.img = img;
	}

	// ***************************getFriends()************************************
	public String[] getFriends() {
		String[] friends = new String[0];
		try {
			Connection cn = ConnexionBD.getConnection();
			String query1 = "select user1 from conversation where user1=" + getUserId() + ";";
			Statement st = (Statement) cn.createStatement();
			ResultSet rs = ((java.sql.Statement) st).executeQuery(query1);
			if (rs.next()) {
				int n = friends.length;
				friends[n] = rs.getString(1);
			}

			String query2 = "select user2 from conversation where user2=" + getUserId() + ";";
			Statement st2 = (Statement) cn.createStatement();
			ResultSet rs2 = ((java.sql.Statement) st2).executeQuery(query2);
			if (rs2.next()) {
				int n = friends.length;
				friends[n] = rs.getString(1);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return friends;
	}

}
