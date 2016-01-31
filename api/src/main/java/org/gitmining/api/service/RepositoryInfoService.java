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
	
	public List<Document> getRepoCollaborators(String repoName){
		return repositoryDao.getRepoCollaborators(repoName);
	}
	
	public List<Document> getRepoContributors(String repoName){
		return repositoryDao.getRepoContributors(repoName);
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
