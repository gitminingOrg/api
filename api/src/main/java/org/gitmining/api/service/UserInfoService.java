package org.gitmining.api.service;

import org.bson.Document;
import org.gitmining.api.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
	@Autowired
	UserDao userDao;
	
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
}
