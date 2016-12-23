package com.elan.sample.app.store.mongo.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "messages")
public class Message {

	public static final String MESSAGE_READ_DATE = "message_read_date";

	public static final String READ = "read";

	public static final String MESSAGE_SENT_DATE = "message_sent_date";

	public static final String RECEIVER_USER_ID = "receiver_user_id";

	public static final String SENDER_USER_ID = "sender_user_id";

	public static final String TEXT = "text";

	@Id
	private String id;

	@Field(value = TEXT)
	private String text;

	@Field(value = SENDER_USER_ID)
	private String senderUserId;

	@Field(value = RECEIVER_USER_ID)
	private String receiverUserId;

	@Field(value = MESSAGE_SENT_DATE)
	private LocalDate messageSentDate;

	@Field(value = READ)
	private Boolean read;

	@Field(value = MESSAGE_READ_DATE)
	private LocalDate messageReadDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public LocalDate getMessageSentDate() {
		return messageSentDate;
	}

	public void setMessageSentDate(LocalDate messageSentDate) {
		this.messageSentDate = messageSentDate;
	}

	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}

	public LocalDate getMessageReadDate() {
		return messageReadDate;
	}

	public void setMessageReadDate(LocalDate messageReadDate) {
		this.messageReadDate = messageReadDate;
	}

	public String getSenderUserId() {
		return senderUserId;
	}

	public void setSenderUserId(String senderUserId) {
		this.senderUserId = senderUserId;
	}

	public String getReceiverUserId() {
		return receiverUserId;
	}

	public void setReceiverUserId(String receiverUserId) {
		this.receiverUserId = receiverUserId;
	}

}
