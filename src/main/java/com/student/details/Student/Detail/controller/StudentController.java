package com.student.details.Student.Detail.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.student.details.Student.Detail.dto.Student;

import com.student.details.Student.Detail.service.StudentService;
import com.student.details.Student.Detail.util.ResponseStructureEntity;

import lombok.extern.slf4j.Slf4j;






@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

	@Autowired
	StudentService studentService;

	
	@PostMapping("/insertStudentDetails")
	    public ResponseEntity<ResponseStructureEntity<Student>> createStudent(@RequestBody Student student) {
				Student insertStudent = studentService.createStudent(student);
				ResponseStructureEntity<Student> responseStructureEntity = new ResponseStructureEntity<Student>();
			responseStructureEntity.setStatusCode(HttpStatus.CREATED.value());
			responseStructureEntity.setMessage("Successfully created");
			responseStructureEntity.setData(insertStudent);
				log.info("Student created successfully :: {}",insertStudent);
				return new ResponseEntity<>(responseStructureEntity, HttpStatus.CREATED);
	    }
	
	 @GetMapping("/fetchStudentById/{studentId}")
	 public ResponseEntity<ResponseStructureEntity<Student>> fetchById(@PathVariable("studentId") Integer studentId)
	 {
		 ResponseStructureEntity<Student> responseStructureEntity = new ResponseStructureEntity	<Student>();
		 responseStructureEntity.setStatusCode(HttpStatus.OK.value());
		 responseStructureEntity.setMessage("Successfully fetched BY ID");
		 Student student = studentService.fetchStudentById(studentId);
		 responseStructureEntity.setData(student);
	        	log.info("Successfully fetched student by id :: {}",student);
	        	return new ResponseEntity<>(responseStructureEntity, HttpStatus.OK);
	 }


	 
	 @GetMapping("/fetchAllStudents")
	 public ResponseEntity<ResponseStructureEntity<List<Student>>> fetchAll(){
		 ResponseStructureEntity<List<Student>> responseStructureEntity = new ResponseStructureEntity<List<Student>>();
		 responseStructureEntity.setStatusCode(HttpStatus.OK.value());
		 responseStructureEntity.setMessage("Successfully fetched all");
		 List<Student> student = studentService.fetchAll();
		 responseStructureEntity.setData(student);

			 log.info("Successfully fetched all students :: {}",student);
	        	return new ResponseEntity<>(responseStructureEntity, HttpStatus.OK);


	 }
	 
	 @DeleteMapping("/deleteByStudentId/{studentId}")
	 public ResponseEntity<ResponseStructureEntity<Student>> deleteById(@PathVariable("studentId") Integer studentId){
		 ResponseStructureEntity<Student> responseStructureEntity = new ResponseStructureEntity<Student>();
		 responseStructureEntity.setStatusCode(HttpStatus.OK.value());
		 responseStructureEntity.setMessage("Successfully deleted by ID");
		 Student student = studentService.deleteById(studentId);
		 responseStructureEntity.setData(student);

			 log.info("Successfully deleted the student using id :: {}",student);
	        	return new ResponseEntity<>(responseStructureEntity, HttpStatus.OK);

	 }
	 
	 @PutMapping("/updateByStudentId/{studentId}")
	 public ResponseEntity<ResponseStructureEntity<Student>> updateById(@PathVariable("studentId") Integer studentId, @RequestBody Student newStudent){
		 ResponseStructureEntity<Student> rse = new ResponseStructureEntity<Student>();
		 rse.setStatusCode(HttpStatus.OK.value());
		 rse.setMessage("Successfully updated by ID");
		 Student student = studentService.fetchStudentById(studentId);
		 newStudent.setStudentId(student.getStudentId());
		 studentService.updateById(newStudent);
		 rse.setData(newStudent);
		 if(newStudent!=null) {
			 log.info("Successfully updated the student using id :: {}",newStudent);
	        	return new ResponseEntity<>(rse, HttpStatus.OK);
	        }
		 return new ResponseEntity<>(rse, HttpStatus.NOT_FOUND);
	 }

	 @PatchMapping("/updateCourseIdsInStudentId/{studentId}")
	 public ResponseEntity<ResponseStructureEntity<Student>> updatedStudentCourseById(@PathVariable("studentId") Integer studentId, @RequestBody List<Integer> coursesId){
		 ResponseStructureEntity<Student> responseStructureEntity = new ResponseStructureEntity<Student>();
		 responseStructureEntity.setStatusCode(HttpStatus.OK.value());
		 responseStructureEntity.setMessage("Successfully updated by ID");
		 Student student = studentService.updatedStudentCourseById(studentId, coursesId);
		 responseStructureEntity.setData(student);
		 log.info("Successfully updated course ids in student :: {}",student);
		 return new ResponseEntity<>(responseStructureEntity, HttpStatus.OK);
	 }
	 
}
