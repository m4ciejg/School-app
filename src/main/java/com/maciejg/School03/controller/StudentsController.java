package com.maciejg.School03.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maciejg.School03.exxception.ResourceNotFoundException;
import com.maciejg.School03.model.LoginForStudents;
import com.maciejg.School03.model.LoginForTeachers;
import com.maciejg.School03.model.Students;
import com.maciejg.School03.repository.LoginForTeachersRepository;
import com.maciejg.School03.repository.LoginForsStudentsRepository;
import com.maciejg.School03.repository.StudentsRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class StudentsController {
	
	@Autowired
	StudentsRepository loginRepository;

	@GetMapping("/students")
	public List<Students> getAll(){
		
		return loginRepository.findAll();
	}
	
	@PostMapping("/students")
	public Students createm(@Valid @RequestBody Students entity) {
		
		return loginRepository.save(entity);
	}

	@GetMapping("/students/{id}")
	public Students getNoteById(@PathVariable(value = "id") Long id) {
	    return loginRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Login", "id", id));
	}

	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") long id){
		
		Students entity = loginRepository.findById(id)
								.orElseThrow(() -> new ResourceNotFoundException("EntityNote", "id", id));
		
		loginRepository.delete(entity);
		
		return ResponseEntity.ok().build();
	}
}