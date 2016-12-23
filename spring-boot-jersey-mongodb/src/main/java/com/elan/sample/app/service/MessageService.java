package com.elan.sample.app.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elan.sample.app.api.ChatMessage;
import com.elan.sample.app.store.mongo.model.Message;
import com.elan.sample.app.store.mongo.repository.messages.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepo;
	
	public void saveMessage(ChatMessage message)
	{
	
		Message dbMessage = new Message();
		dbMessage.setFromEmailId(message.getSenderEmailId());
		dbMessage.setText(message.getMessage());
		dbMessage.setToEmailId(message.getReceiverEmailId());
		dbMessage.setMessageSentDate(LocalDate.now());
		dbMessage.setRead(false);
		
		messageRepo.save(dbMessage);
		
	}
	

}
