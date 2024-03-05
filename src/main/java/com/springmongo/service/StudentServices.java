package com.springmongo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.springmongo.entity.Student;
import com.springmongo.repo.StudentRepo;

@Service
public interface StudentServices {

	

	public void saveorUpdate(Student students);

	public Iterable<Student> listAllStudents();

	public Optional<Student> deleteStudent(String id);

	public Student searchStudentById(String id);
	
	
	

}
