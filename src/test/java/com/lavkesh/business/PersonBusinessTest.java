package com.lavkesh.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.AbstractTransactionManagementConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.lavkesh.model.Address;
import com.lavkesh.model.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml"})
@TransactionConfiguration(transactionManager="transactionManager")
@Transactional
public class PersonBusinessTest extends AbstractTransactionManagementConfiguration {
	
	@Autowired
	private PersonBusiness personBusiness;
	
	@Test
	public void testGetAllPerson(){
		List<Person> allPerson = personBusiness.getAllPerson();
		Assert.assertEquals("Person record not match.",0, allPerson.size());
	}
	
	@Test
	public void testCreatePerson(){
		Person person = new Person();
		person.setFirstName("Lvakesh");
		person.setLasttName("Rathi");
		person.setDob(new Date(86,8,11));
		
		Address address = new Address();
		address.setAddress1("Test Address 1");
		address.setCity("Khamgaon");
		address.setState("Maharashtra");
		address.setCountry("India");
		
		List<Address> addList = new ArrayList<Address>();
		addList.add(address);
		person.setAddressList(addList);
		
		personBusiness.savePerson(person);
		
		List<Person> allPerson = personBusiness.getAllPerson();
		Assert.assertEquals("Person record not match.",1, allPerson.size());
		
		Person person2 = allPerson.get(0);
		List<Address> addressList = person2.getAddressList();
		Assert.assertEquals("Address record not match.",1, addressList.size());
		
		Address address2 = addressList.get(0);
		personBusiness.deleteAddress(address2);
		
		
	}
	
	

}