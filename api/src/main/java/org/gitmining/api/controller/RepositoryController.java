package org.gitmining.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.gitmining.api.service.RepositoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/repository")
public class RepositoryController {
	@Autowired
	private RepositoryInfoService repositoryInfoService;
	
	@RequestMapping({"","/"})
	public List<Document> getAllRepos(HttpServletRequest request,
			HttpServletResponse response){
		return repositoryInfoService.getAllRepos();
	}
	
	@RequestMapping(value = "/{owner}/{reponame}")
	public Document getRepo(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner){
		return repositoryInfoService.getRepoInfo(owner+"/"+reponame);
	}
}
