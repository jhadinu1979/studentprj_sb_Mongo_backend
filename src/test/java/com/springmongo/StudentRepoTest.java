package com.springmongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springmongo.entity.Student;

@Repository
public interface StudentRepoTest extends MongoRepository<Student,String> {
	
	List<Student> findStudentById(String id);

}
