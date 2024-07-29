package com.student.details.Student.Detail.service;

import java.util.List;
import java.util.Optional;

import com.student.details.Student.Detail.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.student.details.Student.Detail.dto.Courses;
import com.student.details.Student.Detail.dto.Student;
import com.student.details.Student.Detail.repo.CourseRepository;

@Service
//@Transactional
@Slf4j
public class CoursesServiceImpl  implements CoursesService {

	@Autowired
	CourseRepository courseRepository;

	@Override
	public Courses createCourse(Courses course) {
		try{
			validateCourse(course);
			return courseRepository.save(course);
		}catch (Exception  e) {

			throw new CourseCreateException( "Student creation failed because : " + e.getMessage());
		}
	}

	@Override
	public Courses fetchCourseById(Integer courseId) {
		Optional<Courses> course = courseRepository.findById(courseId);
		if(course.isPresent())
		{
			return course.get();
		}
		else{
			log.error("Course not found with id: " + courseId);
			throw new CourseFetchFailedException("Course not found with id: " + courseId);
		}
	}

	@Override
	public List<Courses> fetchAll() {
		List<Courses> courses = courseRepository.findAll();
		if(courses!=null)
		{
			return courses;
		}else{
			log.error("No courses found");
			throw new CourseFetchFailedException("No students found");
		}
	}

	@Override
	public Courses deleteById(Integer courseId) {
		Optional<Courses> course = courseRepository.findById(courseId);
		if(course.isPresent()) {
			courseRepository.deleteById(courseId);
			return course.get();
		}else{
			log.error("Course not found for deletion with this id : " + courseId);
			throw new CourseDeleteFailedException("Course not found for deletion with this id : " + courseId);
		}
	}

	@Override
	public Courses updateById(Courses newCourse) {
		return courseRepository.save(newCourse);
	}


	private void validateCourse(Courses course) {
		if (course == null) {
			log.error("Course object cannot be null");
			throw new IllegalArgumentException("Course object cannot be null");
		}
		if ( course.getCourseId() == 0) {
			log.error("Course Id cannot be null (or) zero");
			throw new IllegalArgumentException("Course with ID " + course.getCourseId() + " has a null/zero ID.");
		}
		if (course.getCourseName() == null) {
			log.error("Course Name cannot be null");
			throw new IllegalArgumentException("Course with ID " + course.getCourseId() + " has a null course name.");
		}
		if (course.getCourseDuration() == null) {
			log.error("Course Duration cannot be null");
			throw new IllegalArgumentException("Course with ID " + course.getCourseId() + " has a null duration.");
		}
		if (course.getCourseFee() == 0) {
			log.error("Course Fee cannot be null (or) zero");
			throw new IllegalArgumentException("Course with ID " + course.getCourseId() + " has a null/zero fee.");
		}
		if ( course.getCourseTrainer() == null) {
			log.error("Course Trainer cannot be null");
			throw new IllegalArgumentException("Course with ID " + course.getCourseId() + " has a null trainer value.");
		}

	}



}