package org.gitmining.api.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
@Component
public class MongoQuery {
	private static class MongoInstance{
		private final static MongoClient INSTANCE = new MongoClient(MongoInfo.getMongoServerIp(), 27017);
	}
	
	public List<Document> search(String db,String collection, Map<String,Object> filters){
		Document document = new Document();
		if(filters != null){
			Set<String> keSet = filters.keySet();
			for (String string : keSet) {
				document.append(string, filters.get(string));
			}
		}
		//MongoClient mongoClient = new MongoClient(MongoInfo.getMongoServerIp(), 27017);
		MongoClient mongoClient = MongoInstance.INSTANCE;
		MongoDatabase database = mongoClient.getDatabase(db);
		FindIterable<Document> iterable = database
				.getCollection(collection).find(document);
		List<Document> documents = new ArrayList<Document>();
		iterable.into(documents);
		//mongoClient.close();
		return documents;
	}
	
	public List<Document> searchLimit(String db,String collection, Map<String,Object> filters, int skip, int limit){
		Document document = new Document();
		if(filters != null){
			Set<String> keSet = filters.keySet();
			for (String string : keSet) {
				document.append(string, filters.get(string));
			}
		}
		//MongoClient mongoClient = new MongoClient(MongoInfo.getMongoServerIp(), 27017);
		MongoClient mongoClient = MongoInstance.INSTANCE;
		MongoDatabase database = mongoClient.getDatabase(db);
		FindIterable<Document> iterable = database
				.getCollection(collection).find(document).skip(skip).limit(limit);
		List<Document> documents = new ArrayList<Document>();
		iterable.into(documents);
		//mongoClient.close();
		return documents;
	}
	
	public Document searchOne(String db,String collection, Map<String,Object> filters){
		Document document = new Document();
		if(filters != null){
			Set<String> keSet = filters.keySet();
			for (String string : keSet) {
				document.append(string, filters.get(string));
			}
		}
		//MongoClient mongoClient = new MongoClient(MongoInfo.getMongoServerIp(), 27017);
		MongoClient mongoClient = MongoInstance.INSTANCE;
		MongoDatabase database = mongoClient.getDatabase(db);
		FindIterable<Document> iterable = database
				.getCollection(collection).find(document).limit(1);
		Document document2 = iterable.first();
		document2.remove("_id");
		//mongoClient.close();
		return document2;
	}
	
	public void insert(Object object,String db,String collection){
		Gson gson = new Gson();
		String json = gson.toJson(object);
		//MongoClient mongoClient = new MongoClient(MongoInfo.getMongoServerIp(), 27017);
		MongoClient mongoClient = MongoInstance.INSTANCE;
		MongoDatabase database = mongoClient.getDatabase(db);
		Document document = gson.fromJson(json, Document.class);
		database.getCollection(collection).insertOne(document);
		//mongoClient.close();
	}
}
