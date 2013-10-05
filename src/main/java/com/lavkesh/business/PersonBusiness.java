package com.lavkesh.business;

import java.util.List;

import com.lavkesh.model.Address;
import com.lavkesh.model.Person;

public interface PersonBusiness {
	
	/**
	 * Get All Person
	 * @return
	 */
	public List<Person> getAllPerson();
	
	/**
	 * Save person Object
	 * @param person
	 * @return
	 */
	public Person savePerson(Person person);
	
	/**
	 * Delete Person Object 
	 * @param person
	 */
	public void deletePerson(Person person);
	
	/**
	 * Save Address
	 * @param address
	 * @param personId
	 */
	public void saveAddress(Address address);
	
	/**
	 * Delete Address
	 * @param address
	 */
	public void deleteAddress(Address address);

}