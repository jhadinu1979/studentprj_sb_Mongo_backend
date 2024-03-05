package com.springmongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springmongo.entity.Student;

@Repository
public interface StudentRepo extends MongoRepository<Student,String> {

}
