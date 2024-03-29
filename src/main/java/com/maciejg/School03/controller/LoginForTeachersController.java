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
import com.maciejg.School03.model.LoginForTeachers;
import com.maciejg.School03.repository.LoginForTeachersRepository;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginForTeachersController {
	
	@Autowired
	LoginForTeachersRepository loginRepository;

	@GetMapping("/teachers")
	public List<LoginForTeachers> getAll(){
		
		return loginRepository.findAll();
	}
	
	@PostMapping("/teachers")
	public LoginForTeachers createm(@Valid @RequestBody LoginForTeachers entity) {
		
		return loginRepository.save(entity);
	}

	@GetMapping("/teachers/{id}")
	public LoginForTeachers getNoteById(@PathVariable(value = "id") Long id) {
	    return loginRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Login", "id", id));
	}

	
	@DeleteMapping("/teachers/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") long id){
		
		LoginForTeachers entity = loginRepository.findById(id)
								.orElseThrow(() -> new ResourceNotFoundException("EntityNote", "id", id));
		
		loginRepository.delete(entity);
		
		return ResponseEntity.ok().build();
	}
}