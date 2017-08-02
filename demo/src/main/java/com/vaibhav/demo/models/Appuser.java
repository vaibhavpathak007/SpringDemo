package com.vaibhav.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*we can't define 'user' as table in postgreSQL because its reserved keyword if we used 'this' keyword
as table name hibernate will throw error of resltset not extracted*/
@Entity
@Table(name="appuser")
public class Appuser {
	
	@Id
	private String appuserid;
	private String pass;
	public String getAppuserid() {
		return appuserid;
	}
	public void setAppuserid(String appuserid) {
		this.appuserid = appuserid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Appuser [appuserid=" + appuserid + ", pass=" + pass + "]";
	}
	

}
