package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Conversation;
import models.User;

public class UserDAOImplementation implements UserDAO {

	@Override
	public void addUser(User u) {
		try {
			Connection cn = ConnexionBD.getConnection();
			String rq = "insert into user (`userId`, `fullName`, `email`, `password`, `img`) VALUES ('" + u.getUserId()
					+ "','" + u.getFullName() + "','" + u.getEmail() + "','" + u.getPassword() + "','" + u.getImg()
					+ "');";
			PreparedStatement PreparedStmt = cn.prepareStatement(rq);
			PreparedStmt.executeUpdate(rq);
		} catch (SQLException e) {
			System.out.println("crud Impo\nErreur :" + e);
		}
	}

	@Override
	public void addConversation(Conversation c) {
		try {
			Connection cn = ConnexionBD.getConnection();
			String rq = "insert into conversation (`conversationId`, `user1`, `user2`) VALUES ('"
					+ c.getConversationId() + "','" + c.getUser1() + "','" + c.getUser2() + "');";
			PreparedStatement PreparedStmt = cn.prepareStatement(rq);
			PreparedStmt.executeUpdate(rq);
		} catch (SQLException e) {
			System.out.println("crud Impo\nErreur :" + e);
		}
	}

	@Override
	public List<User> getFriends(User u) {
        List<User> friends = new ArrayList<User>();
        /*Bech nbadel feha
		try {
			Connection cn = ConnexionBD.getConnection();
			String query1 = "select user1 from conversation where user1=" + u.getUserId() + ";";
			Statement st = (Statement) cn.createStatement();
			ResultSet rs = ((java.sql.Statement) st).executeQuery(query1);
			if (rs.next()) {
				int n = friends.length;
				friends[n] = rs.getString(1);
			}

			String query2 = "select user2 from conversation where user2=" + u.getUserId() + ";";
			Statement st2 = (Statement) cn.createStatement();
			ResultSet rs2 = ((java.sql.Statement) st2).executeQuery(query2);
			if (rs2.next()) {
				int n = friends.length;
				friends[n] = rs.getString(1);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		return friends;
	}

	@Override
	public User getFriend(String name) {
		// getih b name mte3ou
		return null;
	}



	@Override
	public Boolean signUp(String fullName, String email, String password, Byte[] img) {
		// verif lel mail
		return null;
	}


}
