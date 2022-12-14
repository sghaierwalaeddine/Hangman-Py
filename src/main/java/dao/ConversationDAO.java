package dao;

import models.Conversation;

public interface ConversationDAO {
	void createConversation(Conversation c);
	void deleteConv(Conversation c);
}
