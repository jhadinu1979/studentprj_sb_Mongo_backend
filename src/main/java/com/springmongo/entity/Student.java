package com.springmongo.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;

@Document(collection = "Students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column(length = 50, nullable =false)
	@Length(min=3, max=20)
	@NotBlank(message = "Student name must not be empty")
	private String studentName;
	@Column(length = 200, nullable =false)
	@Length(min=10, max=50)
	private String studentAddress;
	@Column(length = 11, nullable =false, unique = true)
	@Length(min=10, max=12)
	@NotBlank(message = "Student mobile must not be empty")
	private String mobile;
	public Student(String id, String studentName, String studentAddress, String mobile) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.mobile = mobile;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", studentAddress=" + studentAddress + ", mobile="
				+ mobile + "]";
	}
	
	
	

}
