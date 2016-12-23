package com.elan.sample.app.api;

import java.util.Date;

public class ChatMessage {

	private String senderEmailId;
	private String receiverEmailId;
	private String message;
	private Date messageSentDate;
	private Boolean read;
	private Date messageReadDate;

	public String getSenderEmailId() {
		return senderEmailId;
	}

	public void setSenderEmailId(String senderEmailId) {
		this.senderEmailId = senderEmailId;
	}

	public String getReceiverEmailId() {
		return receiverEmailId;
	}

	public void setReceiverEmailId(String receiverEmailId) {
		this.receiverEmailId = receiverEmailId;
	}

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
}
