package com.vaibhav.demo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.vaibhav.demo.models.Appuser;

public class AuthenticationInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		  System.out.println("pre handle");
		  
		  String uri = request.getRequestURI();
		  if(!uri.endsWith("login.htm") && !uri.endsWith("dologin.htm"))
		  {
		   String user = (String) request.getSession().getAttribute("loggedUser");
		   if(user == null)
		   {
		    response.sendRedirect("login.htm");
		    
		    return false;
		   }   
		  }
		  return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println("post handle");
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("after completion");
		
	}

}
