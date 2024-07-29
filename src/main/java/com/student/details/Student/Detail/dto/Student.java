package com.student.details.Student.Detail.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Student")
public class Student {
	
	@Id
	private Integer  studentId;
	private String studentFirstName;
	private String studentLastName;
	private int studentAge;
	private long studentPhNumber;
	private String studentEmail;
	private String studentAddress;
	private List<Integer> courseIds;

}
