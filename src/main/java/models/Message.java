package models;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Message {
	private String messageId;
	private String convId;
	private String text;
	private SimpleDateFormat sentAt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// je l'ai pas testé

	public Message(String messageId, String convId, String text, SimpleDateFormat sentAt) {
		this.messageId = messageId;
		this.convId = convId;
		this.text = text;
		this.sentAt = sentAt;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getConvId() {
		return convId;
	}

	public void setConvId(String convId) {
		this.convId = convId;
	}


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public SimpleDateFormat getSentAt() {
		return sentAt;
	}

	public void setSentAt(SimpleDateFormat sentAt) {
		this.sentAt = sentAt;
	}

	
}
