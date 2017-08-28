package com.vaibhav.demo.dao;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.vaibhav.demo.models.Appuser;
import com.vaibhav.demo.models.PersonTO;

@Component
public class PersonDao {

	@Autowired
	SessionFactory sessionfactory;
	
	protected final Logger logger = Logger.getLogger(this.getClass());
	
	@Transactional
	public void savePerson(PersonTO person)
	{
		Session session = sessionfactory.getCurrentSession();
		session.save(person);
		logger.debug("person saved:"+ person);
		
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
