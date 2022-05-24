package com.lavkesh.service;

import java.util.List;

import com.lavkesh.model.Address;
import com.lavkesh.model.Student;

public interface StudentService {
	
	/**
	 * Get All Student
	 * @return
	 */
	public List<Student> getAllStudent();

	/**
	 * Get Student Info
	 * @param studentId
	 * @return
	 */
	public Student getStudent(Long studentId);
	
	/**
	 * Save student Object
	 * @param student
	 * @return
	 */
	public Student saveStudent(Student student);
	
	/**
	 * Delete Student Object 
	 * @param studentId
	 */
	public void deleteStudent(Long studentId);
	
	/**
	 * Save Address
	 * @param address
	 * @param studentId
	 */
	public void saveAddress(Address address);
	
	/**
	 * Delete Address
	 * @param address
	 */
	public void deleteAddress(Address address);

}