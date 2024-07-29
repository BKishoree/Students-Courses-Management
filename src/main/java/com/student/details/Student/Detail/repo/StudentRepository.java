package com.student.details.Student.Detail.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.student.details.Student.Detail.dto.Student;

public interface StudentRepository extends MongoRepository<Student, Integer>{

	

}
