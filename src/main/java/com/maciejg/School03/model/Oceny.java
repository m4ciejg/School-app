package com.maciejg.School03.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Oceny {

	@javax.persistence.Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private String grade;
	
}
