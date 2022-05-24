package com.lavkesh.service;

import com.lavkesh.model.Address;
import com.lavkesh.model.Student;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class StudentServiceTest {
	
	@Autowired
	private StudentService studentService;
	
	@Test
	public void testGetAllStudent(){
		List<Student> studentList = studentService.getAllStudent();
		assertThat(0 == studentList.size()).isTrue();
	}
	
	@Test
	public void testCreateStudent(){
		Student student = new Student();
		student.setFirstName("Lavkesh");
		student.setLasttName("Rathi");
		
		Address address = new Address();
		address.setAddress1("Test Address 1");
		address.setCity("Khamgaon");
		address.setState("Maharashtra");
		address.setCountry("India");
		
		List<Address> addList = new ArrayList<Address>();
		addList.add(address);
		student.setAddressList(addList);

		studentService.saveStudent(student);
		
		List<Student> studentList = studentService.getAllStudent();
		assertThat(1 == studentList.size()).isTrue().withFailMessage("Student record not match.");
		
		Student student2 = studentList.get(0);
		List<Address> addressList = student2.getAddressList();
		assertThat(1 == addressList.size()).isTrue().withFailMessage("Address record not match.");
	}
}