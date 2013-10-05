package com.lavkesh.dao;

import java.util.List;

import com.lavkesh.model.Address;
import com.lavkesh.model.Person;

public interface PersonDao extends DAO<Person>{
	
	/**
	 * Return All Person List
	 * @return
	 */
	public List<Person> getAllPerson();
	
	/**
	 * Add address in person
	 * @param personId
	 * @return
	 */
	public Address saveAddress(Address address);
	
	/**
	 * Delete Address
	 * @param address
	 */
	public void deleteAddress(Address address);

}
