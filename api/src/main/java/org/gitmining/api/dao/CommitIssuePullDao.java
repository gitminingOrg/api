package org.gitmining.api.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommitIssuePullDao {
	@Autowired
	MongoQuery mongoQuery;
	
	public List<Document> getRepoComments(String reponame,String commitsha, int skip, int limit){
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("fn", reponame);	
		filter.put("commit_id", commitsha);	
		return mongoQuery.searchLimit(MongoInfo.DB, MongoInfo.COMMENT_COLLECTION, filter,skip,limit);
	}
	
	public List<Document> getRepoIssueComments(String reponame,int issuenum, int skip, int limit){
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("fn", reponame);	
		filter.put("id", issuenum);	
		return mongoQuery.searchLimit(MongoInfo.DB, MongoInfo.ISSUE_COMMENT_COLLECTION, filter,skip,limit);
	}
	
	public List<Document> getRepoCommits(String reponame,int skip, int limit){
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("fn", reponame);		
		return mongoQuery.searchLimit(MongoInfo.DB, MongoInfo.COMMIT_COLLLECTION, filter,skip,limit);
	}
	
	public Document getRepoCommit(String reponame,String sha){
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("fn", reponame);	
		filter.put("sha", sha);
		return mongoQuery.searchOne(MongoInfo.DB, MongoInfo.COMMIT_COLLLECTION, filter);
	}	
	
	public List<Document> getRepoPulls(String reponame,int skip, int limit){
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("fn", reponame);		
		return mongoQuery.searchLimit(MongoInfo.DB, MongoInfo.PULL_COLLECTION, filter,skip,limit);
	}
	
	public Document getRepoPull(String reponame,int number){
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("fn", reponame);	
		filter.put("number", number);
		return mongoQuery.searchOne(MongoInfo.DB, MongoInfo.PULL_COLLECTION, filter);
	}
	
	public List<Document> getRepoIssues(String reponame,int skip, int limit){
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("fn", reponame);		
		return mongoQuery.searchLimit(MongoInfo.DB, MongoInfo.ISSUE_COLLECTION, filter,skip,limit);
	}
	
	public Document getRepoIssue(String reponame,int number){
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("fn", reponame);	
		filter.put("number", number);
		return mongoQuery.searchOne(MongoInfo.DB, MongoInfo.ISSUE_COLLECTION, filter);
	}
}
