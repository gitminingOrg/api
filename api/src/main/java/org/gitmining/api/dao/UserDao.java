package org.gitmining.api.dao;

import java.util.HashMap;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
	@Autowired
	MongoQuery mongoQuery;
	public Document searchUser(String login){
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("login", login);
		return mongoQuery.searchOne(MongoInfo.DB, MongoInfo.USER_COLLECTION, filter); 
	}
}
