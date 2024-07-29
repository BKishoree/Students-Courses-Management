package com.student.details.Student.Detail.service;





import java.util.List;

import com.student.details.Student.Detail.dto.Student;

public interface StudentService {

	
	public Student createStudent(Student student);
	
	public Student fetchStudentById(Integer studentId);
	
	public List<Student> fetchAll();

	public Student deleteById(Integer studentId);

	public Student updateById(Student newStudent);

	public Student updatedStudentCourseById(Integer studentId, List<Integer> coursesId );

}
