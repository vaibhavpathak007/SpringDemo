package com.vaibhav.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vaibhav.demo.dao.LoginDao;
import com.vaibhav.demo.models.Appuser;

@Controller
public class LoginController {
	
	@Autowired
	LoginDao logindao;

	@RequestMapping("/login.htm")
	public String getLogin()
	{
		return "login";
	}
	
	
	@RequestMapping("/dologin.htm")
	public ModelAndView doLogin(@ModelAttribute("user") Appuser user)
	{
		if(logindao.doLogin(user))
		{
			ModelAndView mv = new ModelAndView("registration");
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
	public String getRegisterPage()
	{
			return "registration";
	}
	
	@RequestMapping("/search.htm")
	public String getSearchPage()
	{
			return "search";
	}
	
	
}
