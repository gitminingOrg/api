package org.gitmining.api.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.gitmining.api.dao.PageInfo;
import org.gitmining.api.dao.RepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryInfoService {
	@Autowired
	RepositoryDao repositoryDao;
	
	@Deprecated
	public List<Document> getAllRepos(){
		return repositoryDao.getAllRepos();
	}
	
	public List<String> getAllRepoNames(){
		List<String> names = new ArrayList<String>();
		List<Document> repos = repositoryDao.getAllRepos();
		for (Document document : repos) {
			names.add(document.getString("full_name"));
		}
		return names;
	}
	
	public Document getRepoInfo(String repoName){
		return repositoryDao.getRepo(repoName);
	}
	
	public List<Document> getRepos(int page){
		int skip = (page - 1) * PageInfo.PAGE_COUNT;
		int limit = PageInfo.PAGE_COUNT;
		return repositoryDao.getPageRepos(skip, limit);
	}
	
	public Document getRepoLanguage(String reponame){
		return repositoryDao.getRepoLanguages(reponame);
	}
	
	public List<Document> getRepoCollaborators(String repoName){
		return repositoryDao.getRepoCollaborators(repoName);
	}
	
	public List<Document> getRepoContributors(String repoName){
		return repositoryDao.getRepoContributors(repoName);
	}
	
	public List<String> getContributorNames(String repoName){
		List<Document> documents = repositoryDao.getRepoContributors(repoName);
		List<String> names = new ArrayList<String>();
		for (Document document : documents) {
			names.add(document.getString("login"));
		}
		return names;
	}
	
	public List<String> getCollaboratorNames(String repoName){
		List<Document> documents = repositoryDao.getRepoCollaborators(repoName);
		List<String> names = new ArrayList<String>();
		for (Document document : documents) {
			names.add(document.getString("login"));
		}
		return names;
	}
	
	public List<Document> getRepoBranches(String reponame){
		return repositoryDao.getRepoBranches(reponame);
	}
	
	public List<String> getRepoBranchNames(String reponame){
		List<Document> documents =repositoryDao.getRepoBranches(reponame);
		List<String> names = new ArrayList<String>();
		for (Document document : documents) {
			names.add(document.getString("name"));
		}
		return names;
	}
	
	public Document getRepoBranch(String reponame,String name){
		return repositoryDao.getRepoBranch(reponame,name);
	}
	
	public String getRepoBranchItem(String reponame,String name,String item){
		if(item.equals("commit")){
			item = "commit.sha";
		}
		Document document =  repositoryDao.getRepoBranch(reponame,name);
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
	
	public List<Document> getRepoForks(String reponame,int page){
		int skip = (page - 1) * PageInfo.PAGE_COUNT;
		int limit = PageInfo.PAGE_COUNT;
		return repositoryDao.getRepoForks(reponame, skip, limit);
	}
	
	public List<String> getRepoForkNames(String reponame,int page){
		List<String> result = new ArrayList<String>();
		int skip = (page - 1) * PageInfo.PAGE_COUNT;
		int limit = PageInfo.PAGE_COUNT;
		List<Document> documents =  repositoryDao.getRepoForks(reponame, skip, limit);
		for (Document document : documents) {
			result.add(document.getString("full_name"));
		}
		return result;
	}
	
	public Document getRepoFork(String forkname){
		return repositoryDao.getRepoFork(forkname);
	}
	
	public String getRepoForkItem(String forkname, String item){
		Document document = repositoryDao.getRepoFork(forkname);
		if(item.equals("owner_name")){
			item = "owner.login";
		}else if(item.equals("owner_id")){
			item = "owner.id";
		}else if(item.equals("owner_type")){
			item = "owner.type";
		}
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
	
	public String getRepoItem(String repoName, String item){
		if(item.equals("owner_name")){
			item = "owner.login";
		}else if(item.equals("owner_id")){
			item = "owner.id";
		}else if(item.equals("owner_type")){
			item = "owner.type";
		}
		return repositoryDao.getRepoItem(repoName, item);
	}
}
