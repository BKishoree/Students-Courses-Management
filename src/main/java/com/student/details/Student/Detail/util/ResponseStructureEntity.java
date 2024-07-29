package com.student.details.Student.Detail.util;

import java.util.List;

import com.student.details.Student.Detail.dto.Student;

public class ResponseStructureEntity<T> {

	private int statusCode;
	private String message;
	private T data;
	
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
