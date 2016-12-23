package com.elan.sample.app.store.mongo.repository.messages;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.elan.sample.app.store.mongo.model.Message;
import com.elan.sample.app.store.mongo.repository.BaseRepository;

public class MessageRepositoryImpl extends BaseRepository implements BaseMessageRepository {

	@Override
	public List<Message> findByReceiverUserIdOrSenderUserId(String userId) {
		Criteria searchCriteria = new Criteria().orOperator(Criteria.where(Message.RECEIVER_USER_ID).is(userId), Criteria.where(Message.SENDER_USER_ID).is(userId));
		Query query = new Query(searchCriteria);
		return getMongoOperations().find(query, Message.class);
	}

}
