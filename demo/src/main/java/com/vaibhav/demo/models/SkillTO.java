package com.vaibhav.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="personskill")
public class SkillTO {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int skillid;
	private String skillname;
	private String level;
	private String experience;
	private String lastused;
	
	@ManyToOne
	@JoinColumn(name="personid")
	private PersonTO personTO;

	public int getSkillid() {
		return skillid;
	}

	public void setSkillid(int skillid) {
		this.skillid = skillid;
	}

	public String getSkillname() {
		return skillname;
	}

	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getLastused() {
		return lastused;
	}

	public void setLastused(String lastused) {
		this.lastused = lastused;
	}

	public PersonTO getPersonTO() {
		return personTO;
	}

	public void setPersonTO(PersonTO personTO) {
		this.personTO = personTO;
	}

	@Override
	public String toString() {
		return "SkillTO [skillid=" + skillid + ", skillname=" + skillname + ", level=" + level + ", experience="
				+ experience + ", lastused=" + lastused + "]";
	}
	
	
	
}
