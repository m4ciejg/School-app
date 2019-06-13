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
import com.maciejg.School03.model.Oceny;
import com.maciejg.School03.model.Students;
import com.maciejg.School03.repository.OcenyRepository;

//Probny kontroler do tabeli oceny bez relacji

@CrossOrigin
@RestController
@RequestMapping("/api")
public class OcenyController {

	@Autowired
	OcenyRepository ocenyRepository;
	
	@GetMapping("/oceny")
	public List<Oceny> getAll(){
		
		return ocenyRepository.findAll();
	}
	
	@PostMapping("/oceny")
	public Oceny createm(@Valid @RequestBody Oceny entity) {
		
		return ocenyRepository.save(entity);
	}

	@GetMapping("/oceny/{id}")
	public Oceny getNoteById(@PathVariable(value = "id") Long id) {
	    return ocenyRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Login", "id", id));
	}

	
	@DeleteMapping("/oceny/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") long id){
		
		Oceny entity = ocenyRepository.findById(id)
								.orElseThrow(() -> new ResourceNotFoundException("EntityNote", "id", id));
		
		ocenyRepository.delete(entity);
		
		return ResponseEntity.ok().build();
	}
}
