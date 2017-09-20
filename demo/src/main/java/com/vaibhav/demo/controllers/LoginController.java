package com.vaibhav.demo.controllers;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.vaibhav.demo.dao.LoginDao;
import com.vaibhav.demo.models.Appuser;
import com.vaibhav.demo.models.PersonTO;

@Controller
@RequestMapping("/home/")
public class LoginController extends CommonController {
	
	@Autowired
	LoginDao logindao;
	
	protected final Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping("/login.htm")
	public String getLogin()
	{
		return "login";
	}
	
	
	@RequestMapping("/dologin.htm")
	public ModelAndView doLogin(@ModelAttribute("user") Appuser user, HttpServletRequest request)
	{
		if(logindao.doLogin(user))
		{
			ModelAndView mv = new ModelAndView("redirect:/home/register.htm");
			request.getSession().setAttribute("loggedUser", user.getAppuserid());
			return mv;
		}
		else
		{
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("errmsg", "invalid credentials");
			return mv;
		}
	}
	
	@RequestMapping("/register.htm")
	public ModelAndView getRegisterPage()
	{
		ModelAndView mv = new ModelAndView("registration");
		mv.addObject("formperson",new PersonTO());
		mv.addObject("languageList",getDisplayLanguages());
		mv.addObject("hobbiesList",getDisplayHobbies());
		return mv;
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView customexception(HttpServletRequest req,  Exception ex)
	{
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("url",req.getRequestURI());
		mv.addObject("exception",ex);
		logger.fatal("Exception: "+ex);
		return mv;
	}

	
	
}
