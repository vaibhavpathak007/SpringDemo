package com.vaibhav.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="person")
public class PersonTO {
	
	@Id
	@GeneratedValue(generator = "person_seq_gen")
	@SequenceGenerator(name = "person_seq_gen", sequenceName = "person_sequence", initialValue = 1, allocationSize = 1)
	private int personid ;
	
	private String name;
	
	private String dob;
	
	private String gender;
	
	@ElementCollection
	@CollectionTable(name="person_lang", joinColumns=@JoinColumn(name="personid"))
	@Column(name="language")
	private List<String> language;
	
	@ElementCollection
	@CollectionTable(name="person_hobbies", joinColumns=@JoinColumn(name="personid"))
	@Column(name="hobbies")
	private List<String> hobbies;
	
	private String address;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="personTO")
	private List<SkillTO> skillto = new ArrayList<SkillTO>();

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

	public List<String> getLanguage() {
		return language;
	}

	public void setLanguage(List<String> language) {
		this.language = language;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
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
	

	/*public ArrayList<String> getLanguageList() {
		return languageList;
	}

	public void setLanguageList(ArrayList<String> languageList) {
		this.languageList = languageList;
	}*/

	@Override
	public String toString() {
		return "PersonTO [personid=" + personid + ", name=" + name + ", dob=" + dob + ", gender=" + gender
				+ ", language2=" + language + ", hobbies2=" + hobbies + ", address=" + address + ", skillto=" + skillto
				+ "]";
	}

	
	
	

}
