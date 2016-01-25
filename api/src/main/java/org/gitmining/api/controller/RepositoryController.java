package org.gitmining.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/repository")
public class RepositoryController {
	@RequestMapping(value = "/hello")
	public String getStarted(HttpServletRequest request,
			HttpServletResponse response){
		return "With Best Wishes";
	}
}
