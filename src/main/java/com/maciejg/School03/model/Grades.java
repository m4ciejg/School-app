package com.maciejg.School03.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Grades {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long grade_id;
	
	private String grade;
	
	@ManyToOne
	@JoinColumn(name= "id")
	private Students students;
	
	
}
