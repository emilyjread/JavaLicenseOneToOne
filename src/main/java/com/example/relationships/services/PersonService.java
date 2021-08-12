package com.example.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.relationships.models.Person;
import com.example.relationships.repositories.PersonRepo;

@Service
public class PersonService {
private PersonRepo personRepo;
	
	public PersonService(PersonRepo personRepo) {
		this.personRepo=personRepo;
	}
	
	public Person createPerson(Person p) {
		return personRepo.save(p);
	}
	
	public List<Person> allPersons(){
		return personRepo.findAll();
	}
	
    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepo.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }

    }
}
