package com.student.details.Student.Detail.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentDeleteFailed extends RuntimeException{

    public StudentDeleteFailed(String message) {
        super(message);
    }
}
