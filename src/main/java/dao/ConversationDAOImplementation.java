package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Conversation;

public class ConversationDAOImplementation implements ConversationDAO {
	
	@Override
	public void createConversation(Conversation c) {
		try {
			Connection cn = ConnexionBD.getConnection();
			String rq = "insert into conversation (`conversationId`, `user1`, `user2`) VALUES ('" + c.getConversationId()
					+ "','" + c.getUser1() + "','" + c.getUser2() +"');";
			PreparedStatement PreparedStmt = cn.prepareStatement(rq);
			PreparedStmt.executeUpdate(rq);
		} catch (SQLException e) {
			System.out.println("crud Impo\nErreur :" + e);
		}
	}
	
	@Override
	public void deleteConv(Conversation c) {
		// DELETE FROM conversation WHERE conversationId=;
		try {
			Connection cn = ConnexionBD.getConnection();
			String query = "delete from conversation where conversationId = ?";
			PreparedStatement preparedStmt = cn.prepareStatement(query);
			preparedStmt.setString(1, c.getConversationId());
			preparedStmt.execute();
		} catch (Exception e) {
			System.err.println("ma5edmetch");
			e.printStackTrace();
		}
	}
}
