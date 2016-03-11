package org.gitmining.api.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.spy.memcached.MemcachedClient;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
	@Autowired
	MongoQuery mongoQuery;
	@Autowired
	MemcachedClient memcachedClient;
	
	public Document searchUser(String login){
		Document user = (Document)memcachedClient.get("user-"+login);
		if(user != null){
			return user;
		}else{
			Map<String, Object> filter = new HashMap<String, Object>();
			filter.put("login", login);
			user =  mongoQuery.searchOne(MongoInfo.DB, MongoInfo.USER_COLLECTION, filter); 
			memcachedClient.add("user-"+login, 60*60*6, user);
		}
		return user;
		
	}
	
	public List<Document> searchStargazers(String reponame,int skip,int limit){
		Map<String, Object> filters = new HashMap<String, Object>();
		filters.put("fn", reponame);
		return mongoQuery.searchLimit(MongoInfo.DB, MongoInfo.STAR_COLLECTION, filters, skip, limit); 
	}
	
	public List<Document> searchSubscribers(String reponame,int skip,int limit){
		Map<String, Object> filters = new HashMap<String, Object>();
		filters.put("fn", reponame);
		return mongoQuery.searchLimit(MongoInfo.DB, MongoInfo.SUBSCRIBER_COLLECTION, filters, skip, limit); 
	}
}
