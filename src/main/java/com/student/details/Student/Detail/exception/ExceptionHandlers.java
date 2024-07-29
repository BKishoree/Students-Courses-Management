package com.student.details.Student.Detail.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.student.details.Student.Detail.util.ResponseStructureEntity;

@RestControllerAdvice
public class ExceptionHandlers {
	
	@ExceptionHandler(StudentCreateFailed.class)
	public ResponseEntity<ResponseStructureEntity<String>> studentCreateFailed( StudentCreateFailed studentCreationFailed){
		ResponseStructureEntity<String> responseStructureEntity = new ResponseStructureEntity<String>();
		responseStructureEntity.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		responseStructureEntity.setMessage("Data not found");
		responseStructureEntity.setData(studentCreationFailed.getMessage());
		 return new ResponseEntity<>(responseStructureEntity,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(StudentFetchFailed.class)
	public ResponseEntity<ResponseStructureEntity<String>> studentFetchExcep(StudentFetchFailed sff){
		ResponseStructureEntity<String> responseStructureEntity = new ResponseStructureEntity<String>();
		responseStructureEntity.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructureEntity.setMessage("Data not found");
		responseStructureEntity.setData(sff.getMessage());

		return new ResponseEntity<>(responseStructureEntity,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(CourseCreateException.class)
	public ResponseEntity<ResponseStructureEntity<String>> courseCreateException(CourseCreateException courseCreateException){
		ResponseStructureEntity<String> responseStructureEntity = new ResponseStructureEntity<String>();
		responseStructureEntity.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructureEntity.setMessage("Data not found");
		responseStructureEntity.setData(courseCreateException.getMessage());

		return new ResponseEntity<>(responseStructureEntity,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(StudentDeleteFailed.class)
	public ResponseEntity<ResponseStructureEntity<String>> studentDeleteExcep(StudentDeleteFailed studentDeleteFailed){
		ResponseStructureEntity<String> responseStructureEntity = new ResponseStructureEntity<String>();
		responseStructureEntity.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructureEntity.setMessage("Data not found");
		responseStructureEntity.setData(studentDeleteFailed.getMessage());

		return new ResponseEntity<>(responseStructureEntity,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CourseFetchFailedException.class)
	public  ResponseEntity<ResponseStructureEntity<String>> courseFetchFailedException(CourseFetchFailedException courseFetchFailedException){
		ResponseStructureEntity<String> responseStructureEntity = new ResponseStructureEntity<String>();
		responseStructureEntity.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructureEntity.setMessage("Data not found");
		responseStructureEntity.setData(courseFetchFailedException.getMessage());
		return new ResponseEntity<>(responseStructureEntity,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CourseDeleteFailedException.class)
	public  ResponseEntity<ResponseStructureEntity<String>> courseDeleteFailedException(CourseDeleteFailedException courseDeleteFailedException){
		ResponseStructureEntity<String> responseStructureEntity = new ResponseStructureEntity<String>();
		responseStructureEntity.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructureEntity.setMessage("Data not found");
		responseStructureEntity.setData(courseDeleteFailedException.getMessage());
		return new ResponseEntity<>(responseStructureEntity,HttpStatus.NOT_FOUND);
	}
}
