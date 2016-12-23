package com.elan.sample.app.api;

import java.util.Date;

public class ChatMessage {

	private String senderUserId;
	private String receiverUserId;
	private String message;
	private Date messageSentDate;
	private Boolean read;
	private Date messageReadDate;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getMessageSentDate() {
		return messageSentDate;
	}

	public void setMessageSentDate(Date messageSentDate) {
		this.messageSentDate = messageSentDate;
	}

	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}

	public Date getMessageReadDate() {
		return messageReadDate;
	}

	public void setMessageReadDate(Date messageReadDate) {
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
