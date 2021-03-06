package org.gitmining.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.gitmining.api.service.CommitIssuePullService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/repository")
public class CommitIssuePullController {
	@Autowired
	CommitIssuePullService commitIssuePullService;
	
	@RequestMapping(value = "/{owner}/{reponame}/pulls")
	public List<Document> getRepoPull(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		String fullname = owner+"/"+reponame;
		int page = 1; 
		String pageString = request.getParameter("page");
		if(pageString != null){
			page = Integer.parseInt(pageString);
		}
		return commitIssuePullService.getRepoPulls(fullname, page);
	}	
	
	@RequestMapping(value = "/{owner}/{reponame}/pulls/numbers")
	public List<Integer> getRepoPullNumbers(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		String fullname = owner+"/"+reponame;
		int page = 1; 
		String pageString = request.getParameter("page");
		if(pageString != null){
			page = Integer.parseInt(pageString);
		}
		return commitIssuePullService.getRepoPullNumbers(fullname, page);
	}
	
	@RequestMapping(value = "/{owner}/{reponame}/pull/{number}")
	public Document getRepoPull(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner,@PathVariable("number") int number){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		String fullname = owner+"/"+reponame;
		
		return commitIssuePullService.getRepoPull(fullname, number);
	}
	
	@RequestMapping(value = "/{owner}/{reponame}/pull/{number}/item/{item}")
	public String getRepoPullItem(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner,@PathVariable("number") int number,@PathVariable(value="item") String item){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		String fullname = owner+"/"+reponame;
		
		return commitIssuePullService.getRepoPullItem(fullname, number,item);
	}
	
	@RequestMapping(value = "/{owner}/{reponame}/issues")
	public List<Document> getRepoIssues(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		String fullname = owner+"/"+reponame;
		int page = 1; 
		String pageString = request.getParameter("page");
		if(pageString != null){
			page = Integer.parseInt(pageString);
		}
		return commitIssuePullService.getRepoIssues(fullname, page);
	}	
	
	@RequestMapping(value = "/{owner}/{reponame}/issues/numbers")
	public List<Integer> getRepoIssueNumbers(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		String fullname = owner+"/"+reponame;
		int page = 1; 
		String pageString = request.getParameter("page");
		if(pageString != null){
			page = Integer.parseInt(pageString);
		}
		return commitIssuePullService.getRepoIssueNumbers(fullname, page);
	}	
	
	@RequestMapping(value = "/{owner}/{reponame}/issue/{number}")
	public Document getRepoIssue(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner,@PathVariable("number") int number){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		String fullname = owner+"/"+reponame;
		
		return commitIssuePullService.getRepoIssue(fullname, number);
	}
	
	@RequestMapping(value = "/{owner}/{reponame}/issue/{number}/item/{item}")
	public String getRepoIssueItem(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner,@PathVariable("number") int number,@PathVariable(value="item") String item){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		String fullname = owner+"/"+reponame;
		
		return commitIssuePullService.getRepoIssueItem(fullname, number,item);
	}
	
	@RequestMapping(value = "/{owner}/{reponame}/issue/{number}/comments")
	public List<Document> getRepoIssueComments(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner,@PathVariable("number") int number){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		String fullname = owner+"/"+reponame;
		int page = 1; 
		String pageString = request.getParameter("page");
		if(pageString != null){
			page = Integer.parseInt(pageString);
		}
		return commitIssuePullService.getIssueComments(fullname, number, page);
	}
	
	@RequestMapping(value = "/{owner}/{reponame}/commits")
	public List<Document> getRepoCommit(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		String fullname = owner+"/"+reponame;
		int page = 1; 
		String pageString = request.getParameter("page");
		if(pageString != null){
			page = Integer.parseInt(pageString);
		}
		return commitIssuePullService.getRepoCommits(fullname, page);
	}
	
	@RequestMapping(value = "/{owner}/{reponame}/commits/shas")
	public List<String> getRepoCommitShas(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		String fullname = owner+"/"+reponame;
		int page = 1; 
		String pageString = request.getParameter("page");
		if(pageString != null){
			page = Integer.parseInt(pageString);
		}
		return commitIssuePullService.getRepoCommitsSha(fullname, page);
	}
	
	@RequestMapping(value = "/{owner}/{reponame}/commit/{sha}/comments")
	public List<Document> getRepoCommitComments(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner,@PathVariable("sha") String sha){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		String fullname = owner+"/"+reponame;
		int page = 1; 
		String pageString = request.getParameter("page");
		if(pageString != null){
			page = Integer.parseInt(pageString);
		}
		return commitIssuePullService.getCommitComments(fullname, sha, page);
	}
	
	@RequestMapping(value = "/{owner}/{reponame}/commit/{sha}")
	public Document getRepoCommit(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner,@PathVariable("sha") String sha){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		String fullname = owner+"/"+reponame;
		return commitIssuePullService.getRepoCommit(fullname, sha);
	}
	
	@RequestMapping(value = "/{owner}/{reponame}/commit/{sha}/item/{item}")
	public String getRepoCommitItem(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("reponame") String reponame, @PathVariable("owner") String owner,@PathVariable("sha") String sha,@PathVariable(value="item") String item){
		if(reponame.contains("+")){
			reponame = reponame.replaceAll("\\+", ".");
		}
		if(owner.contains("+")){
			owner = owner.replaceAll("\\+", ".");
		}
		String fullname = owner+"/"+reponame;		
		return commitIssuePullService.getRepoCommitItem(fullname, sha, item);
	}
}
