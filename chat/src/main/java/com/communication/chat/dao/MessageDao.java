package com.communication.chat.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.communication.chat.models.Message;

@Repository
public class MessageDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void saveMessage(Message message) {
		mongoTemplate.save(message);
	}

}
