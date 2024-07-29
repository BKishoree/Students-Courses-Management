package com.student.details.Student.Detail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.details.Student.Detail.dto.Courses;
import com.student.details.Student.Detail.dto.Student;
import com.student.details.Student.Detail.service.CoursesService;
import com.student.details.Student.Detail.service.CoursesServiceImpl;
import com.student.details.Student.Detail.util.ResponseStructureEntity;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CoursesController {

	@Autowired
	CoursesService coursesService;
	
	@PostMapping("/insertCourseDetails")
    public ResponseEntity<ResponseStructureEntity<Courses>> createCourse(@RequestBody Courses course) {
		ResponseStructureEntity<Courses> rse = new ResponseStructureEntity<Courses>();
		rse.setStatusCode(HttpStatus.CREATED.value());
		rse.setMessage("Successfully created");
		Courses insertCourse = coursesService.createCourse(course);
        rse.setData(insertCourse);

        	return new ResponseEntity<>(rse, HttpStatus.CREATED);
    }

 @GetMapping("/fetchCourseById/{courseId}")
 public ResponseEntity<ResponseStructureEntity<Courses>> fetchById(@PathVariable("courseId") Integer courseId)
 {
	 ResponseStructureEntity<Courses> rse = new ResponseStructureEntity<Courses>();
	 rse.setStatusCode(HttpStatus.OK.value());
	 rse.setMessage("Successfully fetched BY ID");
	 Courses course = coursesService.fetchCourseById(courseId);
	 rse.setData(course);

	 return new ResponseEntity<>(rse, HttpStatus.OK);

 }
 
 @GetMapping("/fetchAllCourses")
 public ResponseEntity<ResponseStructureEntity<List<Courses>>> fetchAll(){
	 ResponseStructureEntity<List<Courses>> rse = new ResponseStructureEntity<List<Courses>>();
	 rse.setStatusCode(HttpStatus.OK.value());
	 rse.setMessage("Successfully fetched all");
	 List<Courses> course = coursesService.fetchAll();
	 rse.setData( course);

	 return new ResponseEntity<>(rse, HttpStatus.OK);
 }
 
 @DeleteMapping("/deleteCourseById/{courseId}")
 public ResponseEntity<ResponseStructureEntity<Courses>> deleteById(@PathVariable("courseId") Integer courseId){
	 ResponseStructureEntity<Courses> rse = new ResponseStructureEntity<Courses>();
	 rse.setStatusCode(HttpStatus.OK.value());
	 rse.setMessage("Successfully deleted by ID");
	 Courses course = coursesService.deleteById(courseId);
	 rse.setData(course);

	 return new ResponseEntity<>(rse, HttpStatus.OK);


 }
 
 @PutMapping("/updateByCourseId/{courseId}")
 public ResponseEntity<ResponseStructureEntity<Courses>> updateById(@PathVariable("courseId") Integer courseId, @RequestBody Courses newCourse){
	 ResponseStructureEntity<Courses> rse = new ResponseStructureEntity<Courses>();
	 rse.setStatusCode(HttpStatus.OK.value());
	 rse.setMessage("Successfully updated by ID");
	 Courses course = coursesService.fetchCourseById(courseId);
	 newCourse.setCourseId(course.getCourseId());
	 coursesService.updateById(newCourse);
	 rse.setData(newCourse);
	 if(newCourse!=null) {
        	return new ResponseEntity<>(rse, HttpStatus.OK);
        }
	 return new ResponseEntity<>(rse, HttpStatus.NOT_FOUND);
 }
	
	
}
