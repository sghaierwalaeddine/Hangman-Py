package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Message;

public class MessageDAOImplementation implements MessageDAO {

	@Override
	public void addMessage(Message m) {
		try {
			Connection cn = ConnexionBD.getConnection();
			String rq = "insert into message (`messageId`, `convId`, `text`, `sentAt`) VALUES ('" + m.getMessageId()
					+ "','" + m.getConvId() + "','" + m.getText() + "','" + m.getSentAt() + "');";
			PreparedStatement PreparedStmt = cn.prepareStatement(rq);
			PreparedStmt.execute(rq);
		} catch (SQLException e) {
			System.out.println("Insertion Impo\nErreur :" + e);
		}
	}

}
