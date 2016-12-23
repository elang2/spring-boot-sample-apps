package com.elan.sample.app.store.mongo.repository.messages;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.elan.sample.app.store.mongo.model.Message;

public interface MessageRepository extends MongoRepository<Message, String>, BaseMessageRepository {

	public List<Message> findBySenderUserId(String userId);

	public List<Message> findByReceiverUserId(String userId);

}
