package com.example.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.relationships.models.Person;
import com.example.relationships.services.PersonService;

@Controller
public class PersonController {
	
	private PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person")Person person) {
		
		return "newPerson.jsp";
	}
	
	@RequestMapping(value= "/persons", method=RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person p, BindingResult result){
		if(result.hasErrors()) {
			return "newPerson.jsp";
		}
		else {
			personService.createPerson(p);
			return "redirect:/licenses/new";
		}
		
	}
	
	@RequestMapping("/persons/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
	    Person p= personService.findPerson(id);
	    String licNo = String.valueOf(p.getLicense().getId());
	    while(licNo.length()<8) {
	    	licNo = 0+licNo;
	    }
	    model.addAttribute("person", p);
	    model.addAttribute("licenseNumber", licNo);
	    return "/show.jsp";
	}

}
