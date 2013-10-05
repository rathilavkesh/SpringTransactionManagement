package com.lavkesh.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.lavkesh.dao.HibernateDAO;
import com.lavkesh.dao.PersonDao;
import com.lavkesh.model.Address;
import com.lavkesh.model.Person;

@Repository("personDao")
public class PersonDaoImpl extends HibernateDAO<Person> implements PersonDao {

	@Override
	public List<Person> getAllPerson() {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Person.class);
		return (List<Person>)criteria.list();
	}

	@Override
	public Address saveAddress(Address address) {
		this.saveOrUpdate(address);
		return address;
	}

	@Override
	public void deleteAddress(Address address) {
		address.setPerson(null);
		this.delete(address);
	}

}