package com.amilop.code.amilop.controller;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amilop.code.amilop.entity.Person;
import com.amilop.code.amilop.repository.PersonRepository;

@RestController
@RequestMapping("/amilop")
public class PersonController {
	
	@Autowired
	PersonRepository personRepository;
	
	//Get all user
	
	@GetMapping("/persons")
	public List<Person> getAllPerson(){
		
		return personRepository.findAll();
		
	}
	
	//Add a user
	@PostMapping("/persons")
	public List<Person> createPerson(@Valid @RequestBody List<Person> personlist) {
		
		return personRepository.save(personlist);		 
		
	}
	
	//Get a user with id
	
	@GetMapping("/persons/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable(value="id") Long id){
		
		Person person = personRepository.findOne(id);
		
		if(person==null) {
			
			return ResponseEntity.notFound().build();
			
		}
		
		return ResponseEntity.ok().body(person);
	}
	
	//Update a user
	@PutMapping("/persons/{id}")
	public ResponseEntity<Person> updatePersonRecordById(@PathVariable(value="id") Long id, @Valid @RequestBody Person personUpdate){
		
		Person person = personRepository.findOne(id);
		
		if(person== null) {
			
			return ResponseEntity.notFound().build();
		}
		
		person.setUsername(personUpdate.getUsername());
		person.setEmail(personUpdate.getEmail());
		
		Person updatedPerson = personRepository.save(person);
		return ResponseEntity.ok(updatedPerson);
		
	}
	//Delete a user
@DeleteMapping("/persons/{id}")
public ResponseEntity<Person> deletePerson(@PathVariable(value="id") Long id){
	
	Person person = personRepository.findOne(id);
	if(person==null) {
		
		return ResponseEntity.notFound().build();
	}
	
	personRepository.delete(person);
	return ResponseEntity.ok().build();

}
	
}
