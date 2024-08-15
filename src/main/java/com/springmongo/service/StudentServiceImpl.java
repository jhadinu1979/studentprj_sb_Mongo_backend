package com.springmongo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmongo.entity.Student;
import com.springmongo.repo.StudentRepo;
import com.springmongo.util.NotificationUtil;

@Service
public class StudentServiceImpl implements StudentServices{

	@Autowired
	private StudentRepo repo;
	
	@Override
	public String saveorUpdate(Student students) {
		String message = NotificationUtil.sendEmail(students);
		repo.save(students);
		return students.getId();
		//return new MessageResponse(,message,HttpStatus.OK.value())
	}

	@Override
	public List<Student> listAllStudents() {
		List<Student> allStudents = repo.findAll();
		System.out.print("Getting data from db :" +allStudents);
		return allStudents;
		//return this.repo.findAll();
		
	}

	@Override
	public void deleteStudent(String id) {
		repo.deleteById(id);
		//return null;
	}

	@Override
	public Student searchStudentById(String id) {
		return repo.findById(id).orElseThrow( ()-> 
        new jakarta.persistence.EntityNotFoundException("Student not found with ID: " + id));
	}
	
	/*
	 * public NotificationResponse NotifyByEmail(Student student) {
	 * 
	 * String message = NotificationUtil.sendEmail(student); return new
	 * NotificationResponse(student, "message" ,HttpStatus.OK.value()) }
	 */

	
	
}
