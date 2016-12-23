package com.elan.sample.app.store.mongo.repository.messages;

import java.util.List;

import com.elan.sample.app.store.mongo.model.Message;

public interface BaseMessageRepository {

	public List<Message> findByReceiverUserIdOrSenderUserId(String userId);

}
