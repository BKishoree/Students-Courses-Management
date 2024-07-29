package com.student.details.Student.Detail.service;

import java.util.List;

import com.student.details.Student.Detail.dto.Courses;


public interface CoursesService {


	public Courses createCourse(Courses course);
	
	public Courses fetchCourseById(Integer courseId);
	
	public List<Courses> fetchAll();
	
	public Courses deleteById(Integer courseId);

	public Courses updateById(Courses newCourse);
	

}
