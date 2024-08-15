package com.springmongo.service;

import java.util.List;



import org.springframework.stereotype.Service;


import com.springmongo.entity.Student;


@Service
public interface StudentServices {

	

	public String saveorUpdate(Student students);

	public List<Student> listAllStudents();

	public void deleteStudent(String id);

	public Student searchStudentById(String id);
	
	//public Student NotificationByEmail(Student students);
	
	
	
	
	

}
