package com.lavkesh.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavkesh.business.PersonBusiness;
import com.lavkesh.dao.PersonDao;
import com.lavkesh.model.Address;
import com.lavkesh.model.Person;

@Service("personBusiness")
public class PersonBusinessImpl implements PersonBusiness {
	
	@Autowired
	private PersonDao personDao;

	@Override
	public Person savePerson(Person person) {
		List<Address> addressList = person.getAddressList();
		personDao.saveOrUpdate(person);

		if(addressList != null){
			for(Address address : addressList){
				address.setPerson(person);
				saveAddress(address);
			}
		}

		return person;
	}

	@Override
	public void deletePerson(Person person) {
		List<Address> addressList = person.getAddressList();
		if(addressList != null){
			for(Address address : addressList){
				deleteAddress(address);
			}
		}
		
		person.setAddressList(null);
		deletePerson(person);
	}

	@Override
	public void saveAddress(Address address) {
		this.personDao.saveAddress(address);
	}

	@Override
	public void deleteAddress(Address address) {
		this.personDao.deleteAddress(address);
	}

	@Override
	public List<Person> getAllPerson() {
		return this.personDao.getAllPerson();
	}
}