package org.gitmining.api.controller;

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
}
