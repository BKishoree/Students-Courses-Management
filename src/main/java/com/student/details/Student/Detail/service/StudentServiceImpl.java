package com.student.details.Student.Detail.service;

import java.util.List;
import java.util.Optional;

import com.student.details.Student.Detail.dto.Courses;

import com.student.details.Student.Detail.exception.StudentDeleteFailed;
import com.student.details.Student.Detail.exception.StudentFetchFailed;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.student.details.Student.Detail.dto.Student;
import com.student.details.Student.Detail.repo.StudentRepository;

@Service
//@Transactional
@Slf4j
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CoursesService coursesService;

	@Override
	public Student createStudent(Student student) {

			try{
				validateStudent(student);
				return studentRepository.save(student);
			}catch (Exception  e) {

				throw new StudentFetchFailed("Student creation failed because of : " + e.getMessage());
			}

	}

	@Override
	public Student fetchStudentById(Integer studentId) {
		Optional<Student> student = studentRepository.findById(studentId);
		if(student.isPresent())
		{
			return student.get();
		}
		else{
			log.error("Student not found with id: " + studentId);
			throw new StudentFetchFailed("Student not found with id: " + studentId);
		}
	}

	public List<Student> fetchAll() {
		List<Student> students = studentRepository.findAll();
		if(students!=null)
		{
			return students;
		}else{
			log.error("No students found");
			throw new StudentFetchFailed("No students found");
		}

	}




	@Override
	public Student deleteById(Integer studentId) {
		Optional<Student> student = studentRepository.findById(studentId);
		if(student.isPresent()) {
			studentRepository.deleteById(studentId);
			return student.get();
		} 
		else{
			log.error("Student not found for deletion with this id : " + studentId);
			throw new StudentDeleteFailed("Student not found for deletion with this id : " + studentId);
		}
	}

	@Override
	public Student updateById(Student newStudent) {
		return studentRepository.save(newStudent);
	}

	@Override
	public Student updatedStudentCourseById(Integer studentId, List<Integer> coursesId) {
		Student student = fetchStudentById(studentId);

		 for(Integer courseId : coursesId) {
			 Courses course = coursesService.fetchCourseById(courseId);
		 }

		 student.setCourseIds(coursesId);
		 studentRepository.save(student);
		 return student;

	}

	private void validateStudent(Student student) {
		if (student == null) {
			log.error("Student object cannot be null");
			throw new IllegalArgumentException("Student object cannot be null");
		}
		if (student.getStudentId() == null || student.getStudentId() == 0) {
			log.error("Student Id cannot be null");
			throw new IllegalArgumentException("Student Id cannot be null");
		}
		if (student.getStudentFirstName() == null) {
			log.error("Student First Name cannot be null");
			throw new IllegalArgumentException("Student First Name cannot be null");
		}
		if (student.getStudentLastName() == null) {
			log.error("Student Last Name cannot be null");
			throw new IllegalArgumentException("Student Last Name cannot be null");
		}
		if (student.getStudentEmail() == null) {
			log.error("Student Email cannot be null");
			throw new IllegalArgumentException("Student Email cannot be null");
		}
		if ( student.getStudentAge() == 0) {
			log.error("Student Age cannot be null");
			throw new IllegalArgumentException("Student Age cannot be null");
		}
		if ( student.getStudentPhNumber() == 0) {
			log.error("Student Phone Number cannot be null");
			throw new IllegalArgumentException("Student Phone Number cannot be null");
		}
	}

}
