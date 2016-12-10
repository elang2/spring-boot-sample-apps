package com.elan.sample.app.store.mongo.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "messages")
public class Message {

	@Id
	private String id;

	@Field(value = "text")
	private String text;

	@Field(value = "from_email_id")
	private String fromEmailId;

	@Field(value = "to_email_id")
	private String toEmailId;

	@Field(value = "message_sent_date")
	private LocalDate messageSentDate;

	@Field(value = "read")
	private Boolean read;

	@Field(value = "message_read_date")
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

	public String getFromEmailId() {
		return fromEmailId;
	}

	public void setFromEmailId(String fromEmailId) {
		this.fromEmailId = fromEmailId;
	}

	public String getToEmailId() {
		return toEmailId;
	}

	public void setToEmailId(String toEmailId) {
		this.toEmailId = toEmailId;
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

}
