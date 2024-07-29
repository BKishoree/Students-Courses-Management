package com.student.details.Student.Detail.exception;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class StudentCreateFailed extends RuntimeException {

	public StudentCreateFailed(String message) {
		super(message);
	}


	
	
}
