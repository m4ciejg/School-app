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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maciejg.School03.exxception.ResourceNotFoundException;
import com.maciejg.School03.model.Teachers;
import com.maciejg.School03.repository.TeachersRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TeachersController {
	
	@Autowired
	TeachersRepository teachersRepository;

	@GetMapping("/teachers")
	public List<Teachers> getAll(){
		
		return teachersRepository.findAll();
	}
	
	@PostMapping("/teachers")
	public Teachers createm(@Valid @RequestBody Teachers entity) {
		
		return teachersRepository.save(entity);
	}

	@GetMapping("/teachers/{id}")
	public Teachers getNoteById(@PathVariable(value = "id") Long id) {
	    return teachersRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Login", "id", id));
	}

	
	@DeleteMapping("/teachers/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") long id){
		
		Teachers entity = teachersRepository.findById(id)
								.orElseThrow(() -> new ResourceNotFoundException("EntityNote", "id", id));
		
		teachersRepository.delete(entity);
		
		return ResponseEntity.ok().build();
	}
}