package com.vaibhav.demo.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.vaibhav.demo.dao.PersonDao;
import com.vaibhav.demo.models.Appuser;
import com.vaibhav.demo.models.PersonTO;
import com.vaibhav.demo.models.SkillTO;

@Controller
@RequestMapping("/person/")
public class PersonController extends CommonController {

	@Autowired
	private PersonDao persondao;
	
	protected final Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping("/saveperson.htm")
	public ModelAndView savePerson(@ModelAttribute("formperson") PersonTO person) {
		
		System.out.println("person retrived:"+ person);
		logger.debug("person retrived:"+ person);
		for (SkillTO st : person.getSkillto()) {
			st.setPersonTO(person); 
		}
		persondao.savePerson(person);
		ModelAndView mv = new ModelAndView("redirect:/home/register.htm");
		mv.addObject("message","Person Saved");
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
