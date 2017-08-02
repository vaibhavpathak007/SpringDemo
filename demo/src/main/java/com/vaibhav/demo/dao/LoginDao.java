package com.vaibhav.demo.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.vaibhav.demo.models.Appuser;


@Component
public class LoginDao {
	
	@Autowired
	SessionFactory sessonfactory;
	
	protected final Logger logger = Logger.getLogger(this.getClass());

	@Transactional
	public boolean doLogin(Appuser appuser)
	{
		try
		{
			Session session = sessonfactory.getCurrentSession();
			Appuser results = (Appuser) session.createCriteria(Appuser.class).add(Restrictions.eq("appuserid", appuser.getAppuserid())).add(Restrictions.eq("pass", appuser.getPass())).uniqueResult();
			System.out.println("user: "+appuser.getAppuserid()+" pass: "+appuser.getPass());
			/*String hql = "from User where userid='"+user.getUserid()+"' and password='"+user.getPassword()+"'";
			Query query = session.createQuery(hql);
			List<User> results = (List<User>)query.list();
			Appuser results= (Appuser)session.get(Appuser.class,"user1"); */
			System.out.println("user retrived:"+ results);
			logger.debug("user retrived:"+ results);
			if(results != null)
				return true;
			else 
				return false;
		}
		catch(Exception ex)
		{
			System.out.println("Exception :"+ ex.getCause());
			logger.fatal("Exception :", ex);
		}
		return false;
	}
	
}
