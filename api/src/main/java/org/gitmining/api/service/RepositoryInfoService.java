package org.gitmining.api.service;

import java.util.List;

import org.bson.Document;
import org.gitmining.api.dao.RepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryInfoService {
	@Autowired
	RepositoryDao repositoryDao;
	
	public List<Document> getAllRepos(){
		return repositoryDao.getAllRepos();
	}
	
	public Document getRepoInfo(String repoName){
		return repositoryDao.getRepo(repoName);
	}
}
