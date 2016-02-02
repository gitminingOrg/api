package org.gitmining.api.service;

import java.util.List;

import org.bson.Document;
import org.gitmining.api.dao.CommitIssuePullDao;
import org.gitmining.api.dao.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommitIssuePullService {
	@Autowired
	CommitIssuePullDao commitIssuePullDao;
	
	public List<Document> getRepoCommits(String reponame, int page){
		int skip = (page - 1) * PageInfo.PAGE_COUNT;
		int limit = PageInfo.PAGE_COUNT;
		return commitIssuePullDao.getRepoCommits(reponame, skip, limit);
	}
	public Document getRepoCommit(String reponame, String sha){
		return commitIssuePullDao.getRepoCommit(reponame, sha);
	}
	
	public String getRepoCommitItem(String reponame, String sha, String item){
		if(item.equals("committer")){
			item = "committer.name";
		}else if(item.equals("committer_email")){
			item = "committer.email";
		}
		else if(item.equals("filenumber")){
			item = "stats.filenumber";
		}else if(item.equals("additions")){
			item = "stats.additions";
		}else if(item.equals("deletions")){
			item = "stats.deletions";
		}else if(item.equals("total")){
			item = "stats.total";
		}
		
		Document document = commitIssuePullDao.getRepoCommit(reponame, sha);
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
	
	
	public List<Document> getRepoPulls(String reponame, int page){
		int skip = (page - 1) * PageInfo.PAGE_COUNT;
		int limit = PageInfo.PAGE_COUNT;
		return commitIssuePullDao.getRepoPulls(reponame, skip, limit);
	}
	
	public Document getRepoPull(String reponame, int number){
		return commitIssuePullDao.getRepoPull(reponame, number);
	}
	
	public String getRepoPullItem(String reponame, int number, String item){
		if(item.equals("user")){
			item = "user.login";
		}else if(item.equals("user_id")){
			item = "user.id";
		}else if(item.equals("user_type")){
			item = "user.type";
		}
		Document document = commitIssuePullDao.getRepoPull(reponame, number);
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
	
	public List<Document> getRepoIssues(String reponame, int page){
		int skip = (page - 1) * PageInfo.PAGE_COUNT;
		int limit = PageInfo.PAGE_COUNT;
		return commitIssuePullDao.getRepoIssues(reponame, skip, limit);
	}
	
	public Document getRepoIssue(String reponame, int number){
		return commitIssuePullDao.getRepoIssue(reponame, number);
	}
	
	public String getRepoIssueItem(String reponame, int number, String item){
		if(item.equals("user")){
			item = "user.login";
		}else if(item.equals("user_id")){
			item = "user.id";
		}else if(item.equals("user_type")){
			item = "user.type";
		}
		Document document = commitIssuePullDao.getRepoIssue(reponame, number);
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
	
	public List<Document> getCommitComments(String reponame, String sha, int page){
		int skip = (page - 1) * PageInfo.PAGE_COUNT;
		int limit = PageInfo.PAGE_COUNT;
		return commitIssuePullDao.getRepoComments(reponame, sha, skip, limit);
	}
	
	public List<Document> getIssueComments(String reponame, int issuenum, int page){
		int skip = (page - 1) * PageInfo.PAGE_COUNT;
		int limit = PageInfo.PAGE_COUNT;
		return commitIssuePullDao.getRepoIssueComments(reponame, issuenum, skip, limit);
	}
}
