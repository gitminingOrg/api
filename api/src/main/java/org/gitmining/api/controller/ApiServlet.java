package org.gitmining.api.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.DispatcherServlet;

public class ApiServlet extends DispatcherServlet {
	private Log log = LogFactory.getLog(getClass());
	@Override
	protected void doDispatch(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		log.warn(uri + "\t"+new Date()+"\t"+request.getRemoteHost());
		if(uri.contains(".")){
			uri = uri.replaceAll("\\.", "+");
			response.sendRedirect(uri);
		}else{
			super.doDispatch(request, response);
		}
		
	}

}
