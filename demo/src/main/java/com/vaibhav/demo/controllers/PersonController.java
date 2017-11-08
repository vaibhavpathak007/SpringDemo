package com.vaibhav.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping("/search.htm")
	public ModelAndView getSearchPage()
	{
		String searchvalue = null;
		ModelAndView mv = new ModelAndView("search");
		List<PersonTO> personlist = persondao.searchPerson(searchvalue);
		mv.addObject("personlist",personlist);
		return mv;
	}
	
	@RequestMapping("/getpersonlist.htm")
	public ModelAndView searchPerson(@RequestParam("searchvalue") String searchvalue)
	{
		ModelAndView mv = new ModelAndView("search");
		List<PersonTO> personlist = persondao.searchPerson(searchvalue);
		mv.addObject("personlist",personlist);
		return mv;
	}
	
	@RequestMapping("/editperson.htm")
	public ModelAndView editPerson(@RequestParam("personid") int personid)
	{
		ModelAndView mv = new ModelAndView("registration");
		mv.addObject("formperson",persondao.getPerson(personid));
		mv.addObject("languageList",getDisplayLanguages());
		mv.addObject("hobbiesList",getDisplayHobbies());
		return mv;
	}
	
	@RequestMapping("/deleteperson.htm")
	public ModelAndView deletePerson(@RequestParam("personid") int personid, RedirectAttributes redirectAttributes)
	{
		ModelAndView mv = new ModelAndView("redirect:/person/search.htm");
		boolean state = persondao.deletePerson(personid);
		if(state)
		{
			redirectAttributes.addFlashAttribute("message", "Deleted User Successfully!");
		}
		else {
			redirectAttributes.addFlashAttribute("message", "Fail To Delete User!");
		}
		
		return mv;
	}
	 
	@ResponseBody
	@RequestMapping(value = "/personlistjson")
	public ArrayList<PersonTO> getPersonJsonList()
	{
		ArrayList<PersonTO> personlist = (ArrayList<PersonTO>) persondao.searchPerson(null);
		logger.debug("Json list:" + personlist);
		return personlist;
	}
	
	//RedirectAttributes redirectAttributes
	//redirectAttributes.addFlashAttribute("message", "success logout");
	
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
