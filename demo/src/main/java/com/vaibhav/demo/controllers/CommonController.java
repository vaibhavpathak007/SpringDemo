package com.vaibhav.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.ModelAttribute;



public class CommonController {

	public ArrayList<String> getDisplayLanguages()
	{
		ArrayList<String> lang = new ArrayList<String>();
		lang.add("english");
		lang.add("hindi");
		lang.add("marathi");
	    return lang;
		
	}
	
	public HashMap<String,String> getDisplayHobbies()
	{
		HashMap<String,String> lang = new HashMap<String,String>();
		lang.put("Singing","singing");
		lang.put("Dancing","dancing");
		lang.put("Painting","painting");
	    return lang;
		
	}
	
}
