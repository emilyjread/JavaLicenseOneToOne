package com.example.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.relationships.models.License;
import com.example.relationships.models.Person;
import com.example.relationships.services.LicenseService;
import com.example.relationships.services.PersonService;

@Controller
public class LicenseController {
	private LicenseService licenseService;
	private PersonService personService;
	
	public LicenseController(LicenseService licenseService, PersonService personService) {
		this.licenseService= licenseService;
		this.personService = personService;
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List <Person> persons = personService.allPersons();
		model.addAttribute("persons", persons);
		return "newlicense.jsp";
	}
	
	@RequestMapping(value= "/licenses", method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license") License l, BindingResult result){
		if(result.hasErrors()) {
			return "newlicense.jsp";
		}
		else {
			licenseService.createLicense(l);
			return "redirect:/licenses/new";
		}
		
	}
	

}
