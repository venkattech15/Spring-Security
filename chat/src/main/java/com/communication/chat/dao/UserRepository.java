package com.communication.chat.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.communication.chat.models.User;

@Repository
public class UserRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public User getUserByUserName(String userName) {
		Query query = new Query(Criteria.where("userName").is(userName));
		return mongoTemplate.findOne(query, User.class);
	}

	public User saveUser(User userInfo) {
		return mongoTemplate.save(userInfo);
	}
}
