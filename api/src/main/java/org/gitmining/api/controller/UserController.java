package org.gitmining.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.gitmining.api.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	UserInfoService userInfoService;
	@RequestMapping(value="/{user}")
	public Document getUserInfo(HttpServletRequest request,
			HttpServletResponse response, @PathVariable(value="user") String login){
		return userInfoService.getUserInfo(login);
	}
	
	@RequestMapping(value="/{user}/item/{item}")
	public String getUserInfo(HttpServletRequest request,
			HttpServletResponse response, @PathVariable(value="user") String login, @PathVariable(value="item")String item){
		return userInfoService.getUserItem(login,item);
	}
	
	@RequestMapping(value="/{owner}/{reponame}/stargazers")
	public List<Document> getRepoStars(HttpServletRequest request,
			HttpServletResponse response, @PathVariable(value="owner") String owner, @PathVariable(value="reponame")String reponame){
		String fullname = owner+"/"+reponame;
		int page = 1; 
		String pageString = request.getParameter("page");
		if(pageString != null){
			page = Integer.parseInt(pageString);
		}
		return userInfoService.getRepoStargazers(fullname, page);
	}
	
	@RequestMapping(value="/{owner}/{reponame}/subscribers")
	public List<Document> getRepoSubs(HttpServletRequest request,
			HttpServletResponse response, @PathVariable(value="owner") String owner, @PathVariable(value="reponame")String reponame){
		String fullname = owner+"/"+reponame;
		int page = 1; 
		String pageString = request.getParameter("page");
		if(pageString != null){
			page = Integer.parseInt(pageString);
		}
		return userInfoService.getRepoSubscribers(fullname, page);
	}
	
	@RequestMapping(value="/{owner}/{reponame}/stargazers/names")
	public List<String> getRepoStarNames(HttpServletRequest request,
			HttpServletResponse response, @PathVariable(value="owner") String owner, @PathVariable(value="reponame")String reponame){
		String fullname = owner+"/"+reponame;
		int page = 1; 
		String pageString = request.getParameter("page");
		if(pageString != null){
			page = Integer.parseInt(pageString);
		}
		return userInfoService.getRepoStargazerNames(fullname, page);
	}
	
	@RequestMapping(value="/{owner}/{reponame}/subscribers/names")
	public List<String> getRepoSubNames(HttpServletRequest request,
			HttpServletResponse response, @PathVariable(value="owner") String owner, @PathVariable(value="reponame")String reponame){
		String fullname = owner+"/"+reponame;
		int page = 1; 
		String pageString = request.getParameter("page");
		if(pageString != null){
			page = Integer.parseInt(pageString);
		}
		return userInfoService.getRepoSubscriberNames(fullname, page);
	}
}
