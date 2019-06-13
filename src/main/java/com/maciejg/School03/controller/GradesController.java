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
import com.maciejg.School03.model.Grades;
import com.maciejg.School03.model.Students;
import com.maciejg.School03.repository.GradesRepository;

//Kontroler do tabeli oceny z relacjami

@CrossOrigin
@RestController
@RequestMapping("/api")
public class GradesController {

	@Autowired
	GradesRepository gradesRepository;
	
	@GetMapping("/grades")
	public List<Grades> getAll(){
		
		return gradesRepository.findAll();
	}
	
	@PostMapping("/grades")
	public Grades createm(@Valid @RequestBody Grades entity) {
		
		return gradesRepository.save(entity);
	}

	@GetMapping("/grades/{id}")
	public Grades getNoteById(@PathVariable(value = "id") Long id) {
	    return gradesRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Grades", "id", id));
	}

	
	@DeleteMapping("/grades/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") long id){
		
		Grades entity = gradesRepository.findById(id)
								.orElseThrow(() -> new ResourceNotFoundException("EntityNote", "id", id));
		
		gradesRepository.delete(entity);
		
		return ResponseEntity.ok().build();
	}
}
