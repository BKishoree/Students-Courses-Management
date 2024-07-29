package com.student.details.Student.Detail.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.student.details.Student.Detail.dto.Courses;

public interface CourseRepository extends MongoRepository<Courses, Integer>{

}
