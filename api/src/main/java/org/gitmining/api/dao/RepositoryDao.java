package org.gitmining.api.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryDao {
	@Autowired
	MongoQuery mongoQuery;

	public List<Document> getAllRepos() {
		return mongoQuery.search(MongoInfo.DB, MongoInfo.REPO_COLLECTION, null);
	}

	public List<Document> getPageRepos(int skip, int limit) {
		return mongoQuery.searchLimit(MongoInfo.DB, MongoInfo.REPO_COLLECTION, null,skip,limit);
	}
	
	public Document getRepo(String reponame) {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("full_name", reponame);
		return mongoQuery.searchOne(MongoInfo.DB, MongoInfo.REPO_COLLECTION,
				filter);
	}
	
	public List<Document> getRepoContributors(String reponame){
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("fn", reponame);		
		return mongoQuery.search(MongoInfo.DB, MongoInfo.CONTRIBUTOR_COLLECTION, filter);
	}
	
	public List<Document> getRepoCollaborators(String reponame){
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("fn", reponame);		
		return mongoQuery.search(MongoInfo.DB, MongoInfo.COLLABORATOR_COLLECTION, filter);
	}
		
	public Document getRepoLanguages(String reponame){
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("fn", reponame);
		return mongoQuery.searchOne(MongoInfo.DB, MongoInfo.LANGUAGE_COLLECTION, filter);
	}

	public String getRepoItem(String reponame, String item) {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("full_name", reponame);
		Document document = mongoQuery.searchOne(MongoInfo.DB,
				MongoInfo.REPO_COLLECTION, filter);
		String result = "NOT EXIST";
		if(item.contains(".")){
			String[] items = item.split("\\.");
			if(document.containsKey(items[0])){
				result = document.get(items[0], Document.class).get(items[1]).toString();
			}
		}else if (document.containsKey(item)){
			result = document.get(item).toString();
		}	
		return result;
	}
}
