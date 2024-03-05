package com.springmongo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.springmongo.entity.Student;
import com.springmongo.repo.StudentRepo;

@Component
public class StudentServiceImpl implements StudentServices{

	@Autowired
	private StudentRepo repo;
	
	@Override
	public void saveorUpdate(Student students) {
		repo.save(students);
	}

	@Override
	public Iterable<Student> listAllStudents() {
		return this.repo.findAll();
	}

	@Override
	public Optional<Student> deleteStudent(String id) {
		repo.deleteById(id);
		return null;
	}

	@Override
	public Student searchStudentById(String id) {
		return repo.findById(id).orElseThrow( ()-> 
        new jakarta.persistence.EntityNotFoundException("Student not found with ID: " + id));
	}
	

	
	
}
