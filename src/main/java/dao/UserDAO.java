package dao;

import java.util.List;
import models.Conversation;
import models.User;

public interface UserDAO {
	void addUser(User u);
	void addConversation(Conversation c);
	List<User> getFriends(User u);
	User getFriend(String name);
	//Token : Login(); //f wostha 2eme méthode Boolean verif();
	Boolean signUp(String fullName, String email, String password, Byte[] img); // f wostha verif o5ra
}



