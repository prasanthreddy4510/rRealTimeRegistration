package com.tcs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tcs.models.SsnDetails;
import com.tcs.services.SsnRegistrationService;

@RestController
public class SsaRegistrationController{
	
	@Autowired
	private SsnRegistrationService service;
	
	@PostMapping(
			value="/ssnEnroll",
			consumes="application/json")
	public ResponseEntity<String> handleSubBtn(SsnDetails ssnDetails) {
		
		String s=null;
		if(ssnDetails!=null) {
			Long ssnNumber = service.savindDetails(ssnDetails);
			if(ssnNumber!=null) {
                s="your details are saved with prasanth mcs, here is your SSN numner:"+ssnNumber;
                  ResponseEntity<String> response = new ResponseEntity<String>(s,HttpStatus.CREATED);  
                  return response;
			}

		}
		
		return null;
		
	}
}
