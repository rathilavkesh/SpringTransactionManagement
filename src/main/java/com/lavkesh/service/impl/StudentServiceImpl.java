package com.lavkesh.service.impl;

import java.util.List;
import java.util.Optional;

import com.lavkesh.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavkesh.service.StudentService;
import com.lavkesh.repository.StudentRepository;
import com.lavkesh.model.Address;
import com.lavkesh.model.Student;
import org.springframework.transaction.annotation.Transactional;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Transactional
	@Override
	public Student saveStudent(Student student) {
		// Save Student
		studentRepository.save(student);

		List<Address> addressList = student.getAddressList();
		if (addressList == null || addressList.size() == 0) {
			throw new IllegalArgumentException("Every student need atleast one address.");
		}

		// Save Address
		for(Address address : addressList){
			address.setStudent(student);
			saveAddress(address);
		}
		return student;
	}

	@Transactional
	@Override
	public void deleteStudent(Long studentId) {
		Student student = studentRepository.findById(studentId).orElse(null);
		if (student == null) {
			throw new IllegalArgumentException("No student exist for given id.");
		}

		List<Address> addressList = student.getAddressList();
		if(addressList != null){
			for(Address address : addressList){
				deleteAddress(address);
			}
		}
		
		student.setAddressList(null);
		studentRepository.delete(student);
	}

	@Transactional
	@Override
	public void saveAddress(Address address) {
		this.addressRepository.save(address);
	}

	@Transactional
	@Override
	public void deleteAddress(Address address) {
		this.addressRepository.delete(address);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Student> getAllStudent() {
		return (List<Student>) this.studentRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Student getStudent(Long studentId) {
		Student student = studentRepository.findById(studentId).orElse(null);
		if (student == null) {
			throw new IllegalArgumentException("No student exist for given id.");
		}
		return student;
	}
}