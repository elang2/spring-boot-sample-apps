package com.elan.sample.app.store.mongo.repository.messages;

import java.util.List;

import com.elan.sample.app.store.mongo.model.Message;

public interface BaseMessageRepository {

	/**
	 * Retrieves the messages assocaited with the user.
	 * 
	 * @param userId Id of the user
	 * @return Messages associated with the user where the user is either the sender or receiver of the message
	 */
	public List<Message> findByReceiverUserIdOrSenderUserId(String userId);

}
