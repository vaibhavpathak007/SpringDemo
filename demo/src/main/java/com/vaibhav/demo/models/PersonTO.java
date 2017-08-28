package com.vaibhav.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class PersonTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int personid ;
	private String name;
	private String dob;
	private String gender;
	private String language;
	private String hobbies;
	private String address;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="personTO")
	private List<SkillTO> skillto;

	public int getPersonid() {
		return personid;
	}

	public void setPersonid(int personid) {
		this.personid = personid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<SkillTO> getSkillto() {
		return skillto;
	}

	public void setSkillto(List<SkillTO> skillto) {
		this.skillto = skillto;
	}

	@Override
	public String toString() {
		return "PersonTO [personid=" + personid + ", name=" + name + ", dob=" + dob + ", gender=" + gender
				+ ", language=" + language + ", hobbies=" + hobbies + ", address=" + address + ", skillto=" + skillto
				+ "]";
	}

	
	
	

}
