package org.gitmining.api.service;

import java.util.ArrayList;
import java.util.List;

import net.spy.memcached.MemcachedClient;

import org.bson.Document;
import org.gitmining.api.dao.PageInfo;
import org.gitmining.api.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
	@Autowired
	UserDao userDao;
	@Autowired
	MemcachedClient memcachedClient;
	
	public List<String> getUserNames(int page){
		List<String> names = (List<String>)memcachedClient.get("usernames"+page);
		int skip = (page - 1) * PageInfo.PAGE_COUNT;
		int limit = PageInfo.PAGE_COUNT;
		if(names != null){
			return names;
		}else{
			names = new ArrayList<String>();
			List<Document> users = userDao.getUsers(skip,limit);
			for (Document document : users) {
				names.add(document.getString("login"));
			}
			memcachedClient.add("usernames"+page, 60*60*24, names);
		}
		return names;
	}
	
	public Document getUserInfo(String login){
		return userDao.searchUser(login);
	}
	
	public String getUserItem(String login, String item){
		Document document = userDao.searchUser(login);
		if(!document.containsKey(item)){
			return "NOT FOUND";
		}else{
			return document.get(item).toString();
		}
	}
	
	public List<Document> getRepoStargazers(String reponame, int page){
		int skip = (page - 1) * PageInfo.PAGE_COUNT;
		int limit = PageInfo.PAGE_COUNT;
		return userDao.searchStargazers(reponame, skip, limit);
	}
	
	public List<Document> getRepoSubscribers(String reponame, int page){
		int skip = (page - 1) * PageInfo.PAGE_COUNT;
		int limit = PageInfo.PAGE_COUNT;
		return userDao.searchSubscribers(reponame, skip, limit);
	}
	
	public List<String> getRepoStargazerNames(String reponame, int page){
		int skip = (page - 1) * PageInfo.PAGE_COUNT;
		int limit = PageInfo.PAGE_COUNT;
		List<Document> documents =  userDao.searchStargazers(reponame, skip, limit);
		List<String> names = new ArrayList<String>();
		for (Document document : documents) {
			names.add(document.getString("login"));
		}
		return names;
	}
	
	public List<String> getRepoSubscriberNames(String reponame, int page){
		int skip = (page - 1) * PageInfo.PAGE_COUNT;
		int limit = PageInfo.PAGE_COUNT;
		List<Document> documents =  userDao.searchSubscribers(reponame, skip, limit);
		List<String> names = new ArrayList<String>();
		for (Document document : documents) {
			names.add(document.getString("login"));
		}
		return names;
	}
}
