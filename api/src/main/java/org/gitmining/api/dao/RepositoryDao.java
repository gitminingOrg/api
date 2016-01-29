package org.gitmining.api.dao;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryDao {
	@Autowired
	MongoQuery mongoQuery;
	
	public List<Document> getAllRepos(){
		return mongoQuery.search(MongoInfo.DB, MongoInfo.REPO_COLLECTION, null);
	}
	
	public Document getRepo(String reponame){
		return null;
	}
}
