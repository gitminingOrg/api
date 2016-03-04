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
		int page = 1; 
		String pageString = request.getParameter("page");
		if(pageString != null){
			page = Integer.parseInt(pageString);
		}
		return repositoryInfoService.getRepos(page);
	}
	
	@RequestMapping({"/names"})
	public List<String> getAllRepoNames(HttpServletRequest request,
			HttpServletResponse response){
		return repositoryInfoService.getAllRepoNames();
	}
	
	@RequestMapping(value = "/{owner}/{reponame}")
	public Document getRepo(HttpServletRequest request,HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		return repositoryInfoService.getRepoInfo(owner+"/"+reponame);
	}
	
	@RequestMapping(value = "/{owner}/{reponame}/languages")
	public Document getRepoLanguages(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		return repositoryInfoService.getRepoLanguage(owner+"/"+reponame);
	}
	
	@RequestMapping(value = "/{owner}/{reponame}/item/{item}")
	public String getRepoItem(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner,@PathVariable("item") String item){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		return repositoryInfoService.getRepoItem(owner+"/"+reponame,item);
	}
	
	@RequestMapping(value = "/{owner}/{reponame}/contributors")
	public List<Document> getRepoContributors(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		return repositoryInfoService.getRepoContributors(owner+"/"+reponame);
	}
	
	@RequestMapping(value = "/{owner}/{reponame}/contributors/login")
	public List<String> getRepoContributorsName(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		return repositoryInfoService.getContributorNames(owner+"/"+reponame);
	}
	
	@RequestMapping(value = "/{owner}/{reponame}/collaborators")
	public List<Document> getRepoCollaborators(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		return repositoryInfoService.getRepoCollaborators(owner+"/"+reponame);
	}
	
	@RequestMapping(value = "/{owner}/{reponame}/collaborators/login")
	public List<String> getRepoCollaboratorsName(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		return repositoryInfoService.getCollaboratorNames(owner+"/"+reponame);
	}
	
	
	@RequestMapping(value = "/{owner}/{reponame}/branches")
	public List<Document> getRepoBranches(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		return repositoryInfoService.getRepoBranches(owner+"/"+reponame);
	}
	
	@RequestMapping(value = "/{owner}/{reponame}/branches/names")
	public List<String> getRepoBranchNames(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		return repositoryInfoService.getRepoBranchNames(owner+"/"+reponame);
	}
	
	@RequestMapping(value = "/{owner}/{reponame}/branch/{name}")
	public Document getRepoBranch(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner,  @PathVariable("name") String name){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		return repositoryInfoService.getRepoBranch(owner+"/"+reponame, name);
	}
	
	@RequestMapping(value = "/{owner}/{reponame}/branch/{name}/item/{item}")
	public String getRepoBranchItem(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner,  @PathVariable("name") String name, @PathVariable("item") String item){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		return repositoryInfoService.getRepoBranchItem(owner+"/"+reponame, name,item);
	}
	
	
	@RequestMapping(value = "/{owner}/{reponame}/forks")
	public List<Document> getRepoForks(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		int page = 1; 
		String pageString = request.getParameter("page");
		if(pageString != null){
			page = Integer.parseInt(pageString);
		}
		return repositoryInfoService.getRepoForks(owner+"/"+reponame,page);
	}
	
	@RequestMapping(value = "/{owner}/{reponame}/forks/names")
	public List<String> getRepoForkNames(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		int page = 1; 
		String pageString = request.getParameter("page");
		if(pageString != null){
			page = Integer.parseInt(pageString);
		}
		return repositoryInfoService.getRepoForkNames(owner+"/"+reponame,page);
	}
	
	@RequestMapping(value = "/fork/{owner}/{reponame}")
	public Document getRepoFork(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		return repositoryInfoService.getRepoFork(owner+"/"+reponame);
	}
	
	@RequestMapping(value = "/fork/{owner}/{reponame}/item/{item}")
	public String getRepoForkItem(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner,  @PathVariable("name") String name, @PathVariable("item") String item){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		return repositoryInfoService.getRepoForkItem(owner+"/"+reponame,item);
	}
}
