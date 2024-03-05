package com.springmongo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmongo.entity.Student;
import com.springmongo.service.StudentServices;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1/student")
public class StudentController {

	@Autowired
	private StudentServices studentServices;
	
	@PostMapping(value="/save")
	public String saveStudent(@RequestBody Student students) {
		studentServices.saveorUpdate(students);
		return "Added Student with ID : " +students.getId();
	}
	
	@GetMapping("/get")
	public Iterable<Student> getAllStudents() {		
		return studentServices.listAllStudents();
	}
	
	//Edit the student
	@PutMapping("/update/{id}")
	public Student updateStudent(@RequestBody Student students, @PathVariable(name="id") String id) {
			
		students.setId(id);
		studentServices.saveorUpdate(students);
		return students;
		}

	//Delete the student
	@DeleteMapping("/delete/{id}")	
	public Student deleteStudent(@PathVariable(name="id") String id) {
		Optional<Student> stid = studentServices.deleteStudent(id);
		if(stid.isPresent())
		return stid.get();
		else
		return null;
	}
	
	//Search student
	@RequestMapping("/search/{id}")
	public Student searchStudentById(@PathVariable(name="id") String id) {
		return studentServices.searchStudentById(id);
	}
	
}
