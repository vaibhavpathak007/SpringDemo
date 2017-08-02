package com.vaibhav.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.vaibhav.demo.dao.UserDao;
import com.vaibhav.demo.models.Appuser;

@Controller
public class PersonController {

	@Autowired
	private UserDao userdao;
	
	protected final Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping("/saveuser.htm")
	public ModelAndView saveUser(@ModelAttribute() Appuser user){
		logger.debug("user retrived:"+ user);
		userdao.saveUser(user);
		ModelAndView mv = new ModelAndView("registration");
		mv.addObject("message","saved user");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView customexception(HttpServletRequest req,  Exception ex)
	{
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("url",req.getRequestURI());
		mv.addObject("exception",ex);
		logger.fatal("Exception: "+ex);
		return null;
	}
	
}
