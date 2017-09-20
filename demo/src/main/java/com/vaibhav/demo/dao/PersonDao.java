package com.vaibhav.demo.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
		session.saveOrUpdate(person);
		logger.debug("person saved:"+ person);
		
	}
	
	@Transactional
	public PersonTO getPerson(int id)
	{
		Session session = sessionfactory.getCurrentSession();
		PersonTO pt = session.get(PersonTO.class,id);
		logger.debug("person TO:"+ pt);
		return pt;
		
	}
	
	@Transactional
	public List<PersonTO> searchPerson(String searchvalue) {
		Session session = sessionfactory.getCurrentSession();
		if(searchvalue!= null)
		{
		String s = "from PersonTO where name like '%"+searchvalue+"%' or gender like '%"+searchvalue+"%' or address like '%"+searchvalue+"%'";
		logger.debug("Query : "+s);
		
		 Query q = session.createQuery(s);
		 List<PersonTO> personlist = q.list();
		for (PersonTO personTO : personlist) {
			logger.debug("person : "+personTO);
			}
		return personlist;
		}
		else 
		{
			String s = "from PersonTO";
			logger.debug("Query : "+s);
			Query q = session.createQuery(s);
			List<PersonTO> personlist = q.list();
			for (PersonTO personTO : personlist) {
				logger.debug("person : "+personTO);
				}
			return personlist;
		}
		
	}
	
	@Transactional
	public boolean deletePerson(int personid) {
		try{
			Session session = sessionfactory.getCurrentSession();
			PersonTO pt = session.get(PersonTO.class,personid);
			session.delete(pt);
			return true;
		}
		catch(Exception ex)
		{
			logger.fatal("Exception: "+ex);
			return false;
		}
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
