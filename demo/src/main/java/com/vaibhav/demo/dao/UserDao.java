package com.vaibhav.demo.dao;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaibhav.demo.models.Appuser;

@Component
public class UserDao {

	@Autowired
	SessionFactory sessionfactory;
	
	protected final Logger logger = Logger.getLogger(this.getClass());
	
	@Transactional
	public void saveUser(Appuser user)
	{
		try{
		Session session = sessionfactory.getCurrentSession();
		session.save(user);
		logger.debug("user saved:"+ user);
		}
		catch(Exception ex)
		{
			logger.fatal(ex);
		}
	}
	
	
}
