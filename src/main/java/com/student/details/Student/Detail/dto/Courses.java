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
@Document(collection = "Courses")
public class Courses {

	@Id
	private int courseId;
	private String courseName;
	private String courseDuration;
	private int courseFee;
	private String courseTrainer;
	private List<Integer> studentIds;

}
