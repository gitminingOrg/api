package org.gitmining.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.DispatcherServlet;

public class ApiServlet extends DispatcherServlet {

	@Override
	protected void doDispatch(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if(uri.contains(".")){
			uri = uri.replaceAll("\\.", "+");
			response.sendRedirect(uri);
		}else{
			super.doDispatch(request, response);
		}
		
	}

}
