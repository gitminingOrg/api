package org.gitmining.api.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.spy.memcached.MemcachedClient;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryDao {
	@Autowired
	MongoQuery mongoQuery;
	@Autowired
	MemcachedClient memcachedClient;

	public List<Document> getAllRepos() {
		return mongoQuery.search(MongoInfo.DB, MongoInfo.REPO_COLLECTION, null);
	}

	public List<Document> getPageRepos(int skip, int limit) {
		return mongoQuery.searchLimit(MongoInfo.DB, MongoInfo.REPO_COLLECTION, null,skip,limit);
	}
	
	public Document getRepo(String reponame) {
		Document repo = (Document)memcachedClient.get("repo-"+reponame);
		if(repo != null){
			return repo;
		}else{
			Map<String, Object> filter = new HashMap<String, Object>();
			filter.put("full_name", reponame);
			repo =  mongoQuery.searchOne(MongoInfo.DB, MongoInfo.REPO_COLLECTION,
					filter);
			memcachedClient.add("repo-"+reponame, 60*60*24, repo);
		}
		return repo;
	}
	
	public List<Document> getRepoBranches(String reponame) {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("fn", reponame);
		return mongoQuery.search(MongoInfo.DB, MongoInfo.BRANCH_COLLECTION,filter);
	}
	
	public Document getRepoBranch(String reponame,String name) {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("fn", reponame);
		filter.put("name", name);
		return mongoQuery.searchOne(MongoInfo.DB, MongoInfo.BRANCH_COLLECTION,filter);
	}
	
	public List<Document> getRepoForks(String reponame,int skip, int limit) {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("fn", reponame);
		return mongoQuery.searchLimit(MongoInfo.DB, MongoInfo.FORK_COLLECTION,filter,skip,limit);
	}
	
	public Document getRepoFork(String forkname) {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("full_name", forkname);
		return mongoQuery.searchOne(MongoInfo.DB, MongoInfo.FORK_COLLECTION,filter);
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
		Document document = getRepo(reponame);
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
