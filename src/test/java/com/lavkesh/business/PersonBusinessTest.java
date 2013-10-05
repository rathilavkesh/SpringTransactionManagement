package com.lavkesh.business;

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

}