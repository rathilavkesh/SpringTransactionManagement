package com.lavkesh.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Long personId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lasttName;
	
	@Column(name="DATE_OF_BIRTH")
	private Date dob;
	
	@OneToMany(mappedBy="person")
	private List<Address> addressList;

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLasttName() {
		return lasttName;
	}

	public void setLasttName(String lasttName) {
		this.lasttName = lasttName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Person){
			Person person = (Person)obj;
			return (person.getPersonId() == this.getPersonId());
		}
		return false;
	}

}
